package com.cn.fehorizon.crm.interactive.util;


import com.alibaba.fastjson.JSONObject;
import com.cn.fehorizon.crm.interactive.model.InteractiveRecord;
import com.cn.fehorizon.crm.interactive.serviceImpl.InteractiveRecordServiceImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Properties;

@Component
public class ConsumerUtils {

    @Autowired
    private InteractiveRecordServiceImpl visitInfoServiceImpl;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerUtils.class);


    /************************ 加载配置文件 ************************/
    private static Properties emailProperties = new Properties();

    static {
        try (InputStream resourceAsStream = ConsumerUtils.class.getResourceAsStream("/config/kafka.properties");) {
            emailProperties.load(resourceAsStream);
            LOGGER.info("加载配置文件 kafka.properties");
        } catch (IOException e) {
            LOGGER.error("加载配置文件 kafka.properties 异常", e);
            System.exit(1);
        }
    }

    private static String ip = emailProperties.getProperty("bootstrap.servers");
    private static String groupID = emailProperties.getProperty("group.id");
    private static String timeOutMs = emailProperties.getProperty("zookeeper.session.timeout.ms");
    public static String syncTimeMs = emailProperties.getProperty("zookeeper.sync.time.ms");
    public static String intervalMs = emailProperties.getProperty("auto.commit.interval.ms");
    public static String offsetReset = emailProperties.getProperty("auto.offset.reset");
    public static String keyDeserializer = emailProperties.getProperty("key.deserializer");
    public static String valueDeserializer = emailProperties.getProperty("value.deserializer");


    public KafkaConsumer<String, String> consumer;


    public ConsumerUtils() {
        Properties props = new Properties();
        props.put("bootstrap.servers", ip);
        props.put("group.id", groupID);
        props.put("zookeeper.session.timeout.ms", timeOutMs);
        props.put("zookeeper.sync.time.ms", syncTimeMs);
        props.put("auto.commit.interval.ms", intervalMs);
        props.put("auto.offset.reset", offsetReset);
        props.put("key.deserializer", keyDeserializer);
        props.put("value.deserializer", valueDeserializer);
        consumer = new KafkaConsumer<>(props);
    }


    public void doWork() {
        try {
            consumer.subscribe(Arrays.asList("crm_interactive"));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);

                if (records != null && records.count() > 0) {

                    for (ConsumerRecord<String, String> record : records) {

                        try {
                            JSONObject json = JSONObject.parseObject(record.value());
                            long contactId = json.getLong("contactId");
                            long visitId = json.getLong("visitId");
                            String dataSource = json.getString("dataSource");
                            Timestamp happenTime = json.getTimestamp("happenTime");
                            String personnel = json.getString("personnel");
                            String event = json.getString("event");
                            String eventType = json.getString("eventType");
                            String eventTypeSub = json.getString("eventTypeSub");
                            String employeeID = json.getString("employeeId");
                            String unitID = json.getString("unitId");
                            String shopID = json.getString("shopId");
                            String creator = json.getString("creator");
                            String salePhone = json.getString("salePhone");
                            String receiptNumber = json.getString("receiptNumber");
                            Timestamp cDate = json.getTimestamp("cDate");

                            InteractiveRecord interactiveRecord = new InteractiveRecord();
                            interactiveRecord.setContactId(contactId);
                            interactiveRecord.setVisitId(visitId);
                            interactiveRecord.setDataSource(dataSource);
                            interactiveRecord.setHappenTime(happenTime);
                            interactiveRecord.setPersonnel(personnel);
                            interactiveRecord.setEvent(event);
                            interactiveRecord.setEventType(eventType);
                            interactiveRecord.setEventTypeSub(eventTypeSub);
                            interactiveRecord.setEmployeeID(employeeID);
                            interactiveRecord.setUnitID(unitID);
                            interactiveRecord.setShopID(shopID);
                            interactiveRecord.setCreator(creator);
                            interactiveRecord.setSalePhone(salePhone);
                            interactiveRecord.setReceiptNumber(receiptNumber);
                            interactiveRecord.setcDate(cDate);

                            visitInfoServiceImpl.insert(interactiveRecord);
                            consumer.commitSync();

                        } catch (Exception e) {
                            LOGGER.error("exception {} \n {}", e.getMessage(), record);
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(" kafka 消费异常 {} ", e.getMessage());
        } finally {
            consumer.commitSync();
            consumer.close();
        }
    }

}
