package com.cn.company.serviceImpl;

import com.cn.company.daoImpl.SchoolDaoImpl;
import com.cn.company.model.School;
import com.cn.company.service.SchoolService;
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
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDaoImpl queryDaoImpl;

    @Override
    public List<School> querySchool(int id) {
        return queryDaoImpl.querySchool(id);
    }

    @Override
    public void save(School school) {
        queryDaoImpl.save(school);
    }
}
