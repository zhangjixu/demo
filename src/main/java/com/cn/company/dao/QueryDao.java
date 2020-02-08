package com.cn.company.dao;

import com.cn.company.model.School;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 10:11 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface QueryDao {

    List<School> querySchool(int id);

}
