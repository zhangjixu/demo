package com.cn.company.daoImpl;

import com.cn.company.dao.BaseDao;
import com.cn.company.model.TShardingMetainfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 9:37 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class TShardingMetainfoDaoImpl implements BaseDao<TShardingMetainfo> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TShardingMetainfo> query() {
        String sql = "select * from `t_sharding_metainfo`;";
        List<TShardingMetainfo> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TShardingMetainfo.class));
        return list;
    }

    @Override
    public void insert(TShardingMetainfo tShardingMetainfo) {
        String sql = "insert into `t_sharding_metainfo`(`id`, `shard_type`, `shard_value`, `t_db_id`, `cdate`, `cby`, `udate`, `uby`) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, tShardingMetainfo.getId(), tShardingMetainfo.getShardType(), tShardingMetainfo.getShardValue(),
                tShardingMetainfo.gettDbId(), tShardingMetainfo.getcDate(), tShardingMetainfo.getcBy(), tShardingMetainfo.getuDate(), tShardingMetainfo.getuBy());
    }
}
