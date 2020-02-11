package com.cn.company.daoImpl;

import com.cn.company.dao.BaseDao;
import com.cn.company.model.VisitInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:44 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class VisitInfoDaoImpl implements BaseDao<VisitInfo> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VisitInfo> query() {
        String sql = "select * from `visit_info`;";
        List<VisitInfo> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(VisitInfo.class));
        return list;
    }

    @Override
    public void insert(VisitInfo visitInfo) {
        String sql = "insert into `visit_info`(`id`, `customID`, `visitID`, `data_source`, `happentime`, `people`, `event`, `event_type`, `employeeID`, `unitID`, `shopID`, `cby`, `cdate`) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, visitInfo.getId(), visitInfo.getCustomID(), visitInfo.getVisitID(), visitInfo.getDataSource(), visitInfo.getHappenTime(), visitInfo.getPeople(),
                visitInfo.getEvent(), visitInfo.getEventType(), visitInfo.getEmployeeID(), visitInfo.getUnitID(), visitInfo.getShopID(), visitInfo.getcBy(), visitInfo.getcDate());
    }
}
