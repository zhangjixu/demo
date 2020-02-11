package com.cn.company.service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:52 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface BaseService<T> {

    List<T> query();

    void insert(T t);

}
