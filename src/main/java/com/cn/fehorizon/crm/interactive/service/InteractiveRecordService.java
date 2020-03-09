package com.cn.fehorizon.crm.interactive.service;

import com.alibaba.fastjson.JSONObject;
import com.cn.fehorizon.crm.interactive.model.InteractionCollecion;
import com.cn.fehorizon.crm.interactive.model.InteractionRecord;
import com.cn.fehorizon.crm.interactive.model.InteractiveRecord;

import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:52 PM
 * @Description:
 * @Version: 1.0.0
 */
public interface InteractiveRecordService {

    List<InteractionRecord> findInteractionRecordList(JSONObject json);

    List<InteractionCollecion> findInteractionCollecionList(JSONObject json);

    void insert(InteractiveRecord interactiveRecord);

}
