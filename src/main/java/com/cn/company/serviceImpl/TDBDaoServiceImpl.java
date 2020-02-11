package com.cn.company.serviceImpl;

import com.cn.company.daoImpl.TDBDaoImpl;
import com.cn.company.model.TDB;
import com.cn.company.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 9:29 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class TDBDaoServiceImpl implements BaseService<TDB> {

    @Autowired
    private TDBDaoImpl tdbDaoImpl;

    @Override
    public List<TDB> query() {
        return tdbDaoImpl.query();
    }

    @Override
    public void insert(TDB tdb) {
        tdbDaoImpl.insert(tdb);
    }
}
