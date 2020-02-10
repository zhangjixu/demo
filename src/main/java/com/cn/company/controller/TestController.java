package com.cn.company.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.company.model.School;
import com.cn.company.serviceImpl.SchoolServiceImpl;
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
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private SchoolServiceImpl queryServiceImpl;

    @RequestMapping(value = "/query", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object query(@RequestBody String params) {
        List<School> schools = null;
        try {
            JSONObject json = JSONObject.parseObject(params);
            int id = json.getInteger("id");
            schools = queryServiceImpl.querySchool(id);
            if (schools != null && schools.size() > 0) {
                for (School school : schools) {
                    System.out.println(school);
                }
            }
        } catch (Exception e) {
            LOGGER.error("query exception {}", e.getMessage());
        }

        return schools;
    }


    @RequestMapping(value = "/save", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestBody String params) {
        List<School> schools = null;
        try {
            JSONObject json = JSONObject.parseObject(params);
            int id = json.getInteger("id");
            String name = json.getString("name");
            String modId = json.getString("modId");
            School school = new School();
            school.setId(id);
            school.setName(name);
            school.setModId(modId);
            queryServiceImpl.save(school);
        } catch (Exception e) {
            LOGGER.error("save exception {}", e.getMessage());
        }

        return "success";
    }


}
