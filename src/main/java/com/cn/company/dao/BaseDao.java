package com.cn.company.dao;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:41 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface BaseDao<T> {

    List<T> query();

    void insert(T t);
}
