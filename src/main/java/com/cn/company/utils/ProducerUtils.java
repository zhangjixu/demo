package com.cn.company.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerUtils {
    // create instance for properties to access producer configs
    static final Properties props = new Properties();

    static {
        //Assign localhost id
        props.put("bootstrap.servers", "192.168.0.5:9092");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");
        //props.put("acks", "0");

        //If the request fails, the producer can automatically retry,
        props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

    }

    public static void main(String[] args) throws Exception {

        Producer<String, String> producer = new KafkaProducer<>(props);
        String topicName = "test_zjx";
        for (int i = 1; i < 10; i++) {
            JSONObject json = new JSONObject();
            int id = i;
            String customID = "customID_" + i;
            String visitID = "visitid_" + i;
            int dataSource = i;
            String happenTime = "2019121" + i;
            String people = "people_" + i;
            String event = "event_" + i;
            int eventType = i;
            String employeeID = "employeeId_" + i;
            String unitID = "unitID_" + i;
            String shopID = "shopId_" + i;
            String cBy = "cby_" + i;
            String cDate = "2019111" + i;

            json.put("id", id);
            json.put("customID", customID);
            json.put("visitID", visitID);
            json.put("dataSource", dataSource);
            json.put("happenTime", happenTime);
            json.put("people", people);
            json.put("event", event);
            json.put("eventType", eventType);
            json.put("employeeID", employeeID);
            json.put("unitID", unitID);
            json.put("shopID", shopID);
            json.put("cBy", cBy);
            json.put("cDate", cDate);

            producer.send(new ProducerRecord<>(topicName, json.toJSONString()));
        }
        producer.close();
        System.out.println("发送信息成功");
    }
}