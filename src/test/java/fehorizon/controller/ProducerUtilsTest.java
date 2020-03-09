package fehorizon.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.fehorizon.crm.interactive.util.ProducerUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Properties;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/25 9:00 AM
 * @Description:
 * @Version: 1.0.0
 */
public class ProducerUtilsTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ProducerUtils.class);

    // create instance for properties to access producer configs
    static final Properties props = new Properties();

    static {
        // Assign localhost id
        props.put("bootstrap.servers", "192.168.0.10:9092");

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

    public void doWork() {
        Producer<String, String> producer = new KafkaProducer<>(props);
        String topicName = "crm_interactive";

        for (int i = 1; i < 2; i++) {
            JSONObject json = new JSONObject();
            long contactId = 202002201530445L;
            long visitId = 202002201530445L;
            String dataSource = i + "";
            Date happenTime = new Date();
            String personnel = "personnel" + i;
            String event = "event_" + i;
            String eventType = i + "";
            String eventTypeSub = i + "";
            String employeeID = "employeeId_" + i;
            String unitID = "unitID_" + i;
            String shopID = "shopId_" + i;
            String creator = "creator" + i;
            Date cDate = new Date();

            json.put("contactId", contactId);
            json.put("visitId", visitId);
            json.put("dataSource", dataSource);
            json.put("happenTime", happenTime);
            json.put("personnel", personnel);
            json.put("event", event);
            json.put("eventType", eventType);
            json.put("eventTypeSub", eventTypeSub);
            json.put("employeeID", employeeID);
            json.put("unitID", unitID);
            json.put("shopID", shopID);
            json.put("creator", creator);
            json.put("cDate", cDate);

            System.out.println(json.toJSONString());

            producer.send(new ProducerRecord<>(topicName, json.toJSONString()));
        }

        producer.close();
        LOGGER.warn("生产消息成功");
        System.out.println("生产消息成功");
    }

    public static void main(String[] args) {
        Producer<String, String> producer = new KafkaProducer<>(props);
        String topicName = "crm_interactive";

        for (int i = 1; i < 2; i++) {
            JSONObject json = new JSONObject();
            long contactId = 202002201530445L;
            long visitId = 202002201530445L;
            String dataSource = i + "";
            Date happenTime = new Date();
            String personnel = "personnel" + i;
            String event = "event_" + i;
            String eventType = i + "";
            String eventTypeSub = i + "";
            String employeeId = "employeeId_" + i;
            String unitId = "unitId_" + i;
            String shopId = "shopId_" + i;
            String creator = "creator" + i;
            Date cDate = new Date();

            json.put("contactId", contactId);
            json.put("visitId", visitId);
            json.put("dataSource", dataSource);
            json.put("happenTime", happenTime);
            json.put("personnel", personnel);
            json.put("event", event);
            json.put("eventType", eventType);
            json.put("eventTypeSub", eventTypeSub);
            json.put("employeeId", employeeId);
            json.put("unitId", unitId);
            json.put("shopId", shopId);
            json.put("creator", creator);
            json.put("cDate", cDate);

            System.out.println(json.toJSONString());

            //producer.send(new ProducerRecord<>(topicName, json.toJSONString()));
        }

        producer.close();
        LOGGER.warn("生产消息成功");
        System.out.println("生产消息成功");
    }

}
