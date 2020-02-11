package com.cn.company.daoImpl;

import com.cn.company.dao.BaseDao;
import com.cn.company.model.THost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 9:32 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class THostDaoImpl implements BaseDao<THost> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<THost> query() {
        String sql = "select * from `t_host`;";
        List<THost> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(THost.class));
        return list;
    }

    @Override
    public void insert(THost tHost) {
        String sql = "insert into `t_host`(`id`, `server_ip`, `server_name`, `cdate`, `cby`, `udate`, `uby`) " +
                "values(?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, tHost.getId(), tHost.getServerIp(), tHost.getServerName(), tHost.getcDate(),
                tHost.getcBy(), tHost.getuDate(), tHost.getuBy());
    }
}
