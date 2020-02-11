package com.cn.company.daoImpl;

import com.cn.company.dao.BaseDao;
import com.cn.company.model.TDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 9:17 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class TDBDaoImpl implements BaseDao<TDB> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TDB> query() {
        String sql = "select * from `t_db`;";
        List<TDB> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TDB.class));
        return list;
    }

    @Override
    public void insert(TDB tdb) {
        String sql = "insert into `t_db`(`id`, `t_host_id`, `port`, `db_name`, `username`, `userpwd`, `cdate`, `cby`, `udate`, `uby`) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, tdb.getId(), tdb.gettHostId(), tdb.getPort(), tdb.getDbName(), tdb.getUserName(), tdb.getUserPwd(),
                tdb.getcDate(), tdb.getcBy(), tdb.getuDate(), tdb.getuBy());
    }
}
