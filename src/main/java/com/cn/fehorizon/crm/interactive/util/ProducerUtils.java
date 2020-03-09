package com.cn.fehorizon.crm.interactive.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ProducerUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(ProducerUtils.class);

    /************************ 加载配置文件 ************************/
    private static Properties emailProperties = new Properties();

    static {
        try (InputStream resourceAsStream = ProducerUtils.class.getResourceAsStream("/config/kafka.properties");) {
            emailProperties.load(resourceAsStream);
            LOGGER.info("加载配置文件 kafka.properties");
        } catch (IOException e) {
            LOGGER.error("加载配置文件 kafka.properties 异常", e);
            System.exit(1);
        }
    }

    private static String ip = emailProperties.getProperty("bootstrap.servers");

    // create instance for properties to access producer configs
    static final Properties props = new Properties();

    static {
        // Assign localhost id
        props.put("bootstrap.servers", ip);

        // Set acknowledgements for producer requests.
        props.put("acks", "all");
        //props.put("acks", "0");

        // If the request fails, the producer can automatically retry,
        props.put("retries", 0);

        // Specify buffer size in config
        props.put("batch.size", 16384);

        // Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        // The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

    }

    public void doWork(JSONObject json) {
        Producer<String, String> producer = new KafkaProducer<>(props);
        String topicName = "crm_interactive";
        producer.send(new ProducerRecord<>(topicName, json.toJSONString()));
        producer.close();
        LOGGER.warn("生产消息成功");
    }
}