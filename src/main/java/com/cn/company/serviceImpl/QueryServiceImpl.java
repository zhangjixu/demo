package com.cn.company.serviceImpl;

import com.cn.company.daoImpl.QueryDaoImpl;
import com.cn.company.model.School;
import com.cn.company.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 10:20 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDaoImpl queryDaoImpl;

    @Override
    public List<School> querySchool(int id) {
        return queryDaoImpl.querySchool(id);
    }
}
