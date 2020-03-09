package com.cn.fehorizon.crm.interactive.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cn.fehorizon.crm.interactive.model.InteractionCollecion;
import com.cn.fehorizon.crm.interactive.model.InteractionRecord;
import com.cn.fehorizon.crm.interactive.model.KakaFlag;
import com.cn.fehorizon.crm.interactive.model.ResultSet;
import com.cn.fehorizon.crm.interactive.serviceImpl.InteractiveRecordServiceImpl;
import com.cn.fehorizon.crm.interactive.util.ConsumerUtils;
import com.cn.fehorizon.crm.interactive.util.ProducerUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 9:24 PM
 * @Description:
 * @Version: 1.0.0
 */
@RestController
@RequestMapping("/crm")
public class InteractiveRecordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InteractiveRecordController.class);

    @Autowired
    private InteractiveRecordServiceImpl visitInfoServiceImpl;

    @Autowired
    private ConsumerUtils consumerUtils;

    @Autowired
    private ProducerUtils producerUtils;

    /**
     * 查询交互记录接口
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findInteractionRecordList", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object findInteractionRecordList(@RequestBody String params) {
        ResultSet resultSet = new ResultSet();
        List<InteractionRecord> list = null;
        try {
            JSONObject json = JSONObject.parseObject(params);
            Long visitID = json.getLong("visitId");
            String creator = json.getString("creator");
            Integer permission = json.getInteger("permission");

            if (visitID == null || StringUtils.isBlank(creator) || permission == null) {
                resultSet.setCode(102);
                resultSet.setMessage("有必填字段为空");
                return resultSet;
            }

            list = visitInfoServiceImpl.findInteractionRecordList(json);
            resultSet.setCode(100);
            resultSet.setResult(list);
        } catch (Exception e) {
            resultSet.setCode(101);
            resultSet.setMessage("程序异常, 异常信息 " + e.getMessage());
            LOGGER.error(" findInteractionRecordList exception {} ", e.getMessage());
        }
        return JSONObject.toJSONString(resultSet, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 查询交互记录集合接口
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/findInteractionCollecionList", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object findInteractionCollecionList(@RequestBody String params) {
        ResultSet resultSet = new ResultSet();
        List<InteractionCollecion> list = null;
        try {
            JSONObject json = JSONObject.parseObject(params);

            String creator = json.getString("creator");
            Integer permission = json.getInteger("permission");
            JSONArray queryObjIds = json.getJSONArray("queryObjIds");

            if (StringUtils.isBlank(creator) || permission == null || queryObjIds == null) {
                resultSet.setCode(102);
                resultSet.setMessage("有必填字段为空");
                return resultSet;
            }
            list = visitInfoServiceImpl.findInteractionCollecionList(json);
            resultSet.setCode(100);
            resultSet.setResult(list);
        } catch (Exception e) {
            resultSet.setCode(101);
            resultSet.setMessage("程序异常, 异常信息 " + e.getMessage());
            LOGGER.error(" qfindInteractionCollecionListuery exception {} ", e.getMessage());
        }
        return JSONObject.toJSONString(resultSet, SerializerFeature.WriteMapNullValue);
    }


    /**
     *  消费 kafka 中的数据
     * @return
     */
    @RequestMapping(value = "/consumeData", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public Object consumeData() {
        String msg = "";
        try {
            if (KakaFlag.flag) {
                KakaFlag.flag = false;
                consumerUtils.doWork();
            }
            msg = "正在消费数据...";
        } catch (Exception e) {
            LOGGER.error("consumeData exception {}", e.getMessage());
        }

        return msg;
    }

    /**
     *  向 kafka 中生产数据
     * @return
     */
    @RequestMapping(value = "/produceData", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object produceData(@RequestBody String params) {
        String flag = "false";
        try {
            JSONObject json = JSONObject.parseObject(params);
            producerUtils.doWork(json);
            System.out.println("开始运行");
            flag = "success";
        } catch (Exception e) {
            LOGGER.error("produceData exception {}", e.getMessage());
        }

        return flag;
    }


}
