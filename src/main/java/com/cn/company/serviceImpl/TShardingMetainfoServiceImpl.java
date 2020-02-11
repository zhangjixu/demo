package com.cn.company.serviceImpl;

import com.cn.company.daoImpl.TShardingMetainfoDaoImpl;
import com.cn.company.model.TShardingMetainfo;
import com.cn.company.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 9:41 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class TShardingMetainfoServiceImpl implements BaseService<TShardingMetainfo> {

    @Autowired
    private TShardingMetainfoDaoImpl tShardingMetainfoDaoImpl;

    @Override
    public List<TShardingMetainfo> query() {
        return tShardingMetainfoDaoImpl.query();
    }

    @Override
    public void insert(TShardingMetainfo tShardingMetainfo) {
        tShardingMetainfoDaoImpl.insert(tShardingMetainfo);
    }
}
