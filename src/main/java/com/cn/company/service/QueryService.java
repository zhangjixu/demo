package com.cn.company.service;

import com.cn.company.model.School;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 10:19 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface QueryService {

    List<School> querySchool(int id);

}
