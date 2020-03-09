package fehorizon.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.fehorizon.crm.interactive.controller.InteractiveRecordController;
import com.cn.fehorizon.crm.interactive.model.ResultSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 9:50 PM
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class ControllerTest {

    @Autowired
    private InteractiveRecordController interactiveRecordController;

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    @Test
    public void testInteractiveRecordController() {
        JSONObject json = new JSONObject();
        json.put("visitId", 12345678);
        json.put("creator", "创建人");
        json.put("permission", "3");
        json.put("contactId", 12345678);
        json.put("eventType", null);

        System.out.println("\n" + interactiveRecordController.findInteractionRecordList(json.toJSONString()));

        ResultSet resultSet = (ResultSet) interactiveRecordController.findInteractionRecordList(json.toJSONString());
        System.out.println("\n" + resultSet);
    }

    @Test
    public void test() {
        String sql = "select `event_type_sub`, `event`, `employee_id`, `happen_time` from `interactive_record`;";
        List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
        Map<String, Object> map = new HashMap<>();


    }

    @Test
    public void testJson() {

        JSONObject json = new JSONObject();
        json.put("a", 1);
        json.put("b", 1);


        JSONObject json1 = new JSONObject();
        json1.put("a", 1);
        json1.put("b", 2);

        JSONArray arr = new JSONArray();
        arr.add(json);
        arr.add(json1);


    }

    @Test
    public void testStr() {
        for (int i = 1; i < 2; i++) {
            JSONObject json = new JSONObject();
            long contactID = 202002201530445L;
            long visitID = 202002201530445L;
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

            json.put("contactID", contactID);
            json.put("visitID", visitID);
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

        }
    }

}
