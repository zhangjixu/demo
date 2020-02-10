package com.cn.company.daoImpl;

import com.cn.company.dao.SchoolDao;
import com.cn.company.model.School;
import com.cn.company.utils.MultipleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 10:14 PM
 * @Description:
 * @Version: 1.0.0
 */
@Repository
public class SchoolDaoImpl implements SchoolDao {

    @Autowired
    private JdbcTemplate mysqlJdbcTemplate;

    @Override
    public List<School> querySchool(int id) {
        MultipleDataSource.setDatabase(id);
        String sql = "select * from `school`";
        List<School> list = mysqlJdbcTemplate.query(sql, new BeanPropertyRowMapper<School>(School.class));
        return list;
    }

    @Override
    public void save(School school) {
        int id = school.getId();
        MultipleDataSource.setDatabase(id);
        String sql = "insert into school values(?, ?, ?)";
        mysqlJdbcTemplate.update(sql, school.getId(), school.getName(), school.getModId());
    }


}
