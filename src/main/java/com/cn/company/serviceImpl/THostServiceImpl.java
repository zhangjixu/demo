package com.cn.company.serviceImpl;

import com.cn.company.daoImpl.THostDaoImpl;
import com.cn.company.model.THost;
import com.cn.company.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 9:42 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class THostServiceImpl implements BaseService<THost> {

    @Autowired
    private THostDaoImpl tHostDaoImpl;

    @Override
    public List<THost> query() {
        return tHostDaoImpl.query();
    }

    @Override
    public void insert(THost tHost) {
        tHostDaoImpl.insert(tHost);
    }
}
