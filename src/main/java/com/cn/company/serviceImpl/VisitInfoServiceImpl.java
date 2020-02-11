package com.cn.company.serviceImpl;

import com.cn.company.daoImpl.VisitInfoDaoImpl;
import com.cn.company.model.VisitInfo;
import com.cn.company.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:55 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class VisitInfoServiceImpl implements BaseService<VisitInfo> {

    @Autowired
    private VisitInfoDaoImpl visitInfoDaoImpl;

    @Override
    public List<VisitInfo> query() {
        return visitInfoDaoImpl.query();
    }

    @Override
    public void insert(VisitInfo visitInfo) {
        visitInfoDaoImpl.insert(visitInfo);
    }
}
