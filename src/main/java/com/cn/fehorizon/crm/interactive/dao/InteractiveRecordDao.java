package com.cn.fehorizon.crm.interactive.dao;

import com.cn.fehorizon.crm.interactive.model.InteractionCollecion;
import com.cn.fehorizon.crm.interactive.model.InteractionRecord;
import com.cn.fehorizon.crm.interactive.model.InteractiveRecord;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:41 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface InteractiveRecordDao {

    List<InteractionRecord> findInteractionRecordList(String sql);

    List<InteractionCollecion> findInteractionCollecionList(String sql);

    void insert(InteractiveRecord interactiveRecord);
}
