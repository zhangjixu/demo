package com.cn.fehorizon.crm.interactive.daoImpl;

import com.cn.fehorizon.crm.interactive.dao.InteractiveRecordDao;
import com.cn.fehorizon.crm.interactive.model.InteractionCollecion;
import com.cn.fehorizon.crm.interactive.model.InteractionRecord;
import com.cn.fehorizon.crm.interactive.model.InteractiveRecord;
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
public class InteractiveRecordDaoImpl implements InteractiveRecordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<InteractionRecord> findInteractionRecordList(String sql) {
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<InteractionRecord>(InteractionRecord.class));
    }

    @Override
    public List<InteractionCollecion> findInteractionCollecionList(String sql) {
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<InteractionCollecion>(InteractionCollecion.class));
    }

    @Override
    public void insert(InteractiveRecord interactiveRecord) {
        String sql = "insert into `interactive_record`(`contact_id`, `visit_id`, `data_source`, `happen_time`, `personnel`, `event`, `event_type`, `event_type_sub`, `employee_id`, `unit_id`, `shop_id`, `creator`, `sale_phone`, `receipt_number`, `cdate`) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, interactiveRecord.getContactId(), interactiveRecord.getVisitId(), interactiveRecord.getDataSource(), interactiveRecord.getHappenTime(), interactiveRecord.getPersonnel(),
                interactiveRecord.getEvent(), interactiveRecord.getEventType(), interactiveRecord.getEventTypeSub(), interactiveRecord.getEmployeeID(), interactiveRecord.getUnitID(), interactiveRecord.getShopID(),
                interactiveRecord.getCreator(), interactiveRecord.getSalePhone(), interactiveRecord.getReceiptNumber(), interactiveRecord.getcDate());
    }
}
