package com.cn.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.company.model.THost;
import com.cn.company.model.VisitInfo;
import com.cn.company.serviceImpl.THostServiceImpl;
import com.cn.company.serviceImpl.VisitInfoServiceImpl;
import com.cn.company.utils.ConsumerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 9:24 PM
 * @Description:
 * @Version: 1.0.0
 */
@RestController
public class VisitInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitInfoController.class);

    @Autowired
    private VisitInfoServiceImpl visitInfoServiceImpl;

    @Autowired
    private ConsumerUtils consumerUtils;


    @RequestMapping(value = "/query", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object query(@RequestBody String params) {
        List<VisitInfo> list  = null;
        try {
           list = visitInfoServiceImpl.query();
        } catch (Exception e) {
            LOGGER.error(" query {} ", e.getMessage());
        }
        return list;
    }




    @RequestMapping(value = "/save", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestBody String params) {
        String flag = "false";
        try {
            consumerUtils.doWork();
            flag = "success";
        } catch (Exception e) {
            LOGGER.error("save exception {}", e.getMessage());
        }

        return flag;
    }





}
