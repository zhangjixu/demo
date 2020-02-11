package com.cn.company.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 9:50 PM
 * @Description:
 * @Version: 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:springmvc-servlet.xml", "classpath*:applicationContext.xml"})
public class VisitInfoController {

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    @Test
    public void test() {
        String sql = "select 1 from dual;";
        mysqlJdbcTemplate.update(sql);
    }

}
