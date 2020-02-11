package com.cn.company.utils;


import com.alibaba.fastjson.JSONObject;
import com.cn.company.model.THost;
import com.cn.company.model.VisitInfo;
import com.cn.company.serviceImpl.THostServiceImpl;
import com.cn.company.serviceImpl.VisitInfoServiceImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

@Component
public class ConsumerUtils {

    @Autowired
    private VisitInfoServiceImpl visitInfoServiceImpl;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerUtils.class);


    /************************ 加载配置文件 ************************/
    private static Properties emailProperties = new Properties();

    static {
        try (InputStream resourceAsStream = EmailUtils.class.getResourceAsStream("/config/kafka.properties");) {
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
            consumer.subscribe(Arrays.asList("test_zjx"));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(10);

                if (records != null && records.count() > 0) {

                    for (ConsumerRecord<String, String> record : records) {

                        JSONObject json = JSONObject.parseObject(record.value());
                        int id = json.getInteger("id");
                        String customID = json.getString("customID");
                        String visitID = json.getString("visitID");
                        int dataSource = json.getInteger("dataSource");
                        String happenTime = json.getString("happenTime");
                        String people = json.getString("people");
                        String event = json.getString("event");
                        int eventType = json.getInteger("eventType");
                        String employeeID = json.getString("employeeID");
                        String unitID = json.getString("unitID");
                        String shopID = json.getString("shopID");
                        String cBy = json.getString("cBy");
                        String cDate = json.getString("cDate");
                        VisitInfo visitInfo = new VisitInfo();
                        visitInfo.setId(id);
                        visitInfo.setCustomID(customID);
                        visitInfo.setVisitID(visitID);
                        visitInfo.setDataSource(dataSource);
                        visitInfo.setHappenTime(happenTime);
                        visitInfo.setPeople(people);
                        visitInfo.setEvent(event);
                        visitInfo.setEventType(eventType);
                        visitInfo.setEmployeeID(employeeID);
                        visitInfo.setUnitID(unitID);
                        visitInfo.setShopID(shopID);
                        visitInfo.setcBy(cBy);
                        visitInfo.setcDate(cDate);
                        visitInfoServiceImpl.insert(visitInfo);
                        consumer.commitSync();

                        System.out.println("============= 消费成功 =============");

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
