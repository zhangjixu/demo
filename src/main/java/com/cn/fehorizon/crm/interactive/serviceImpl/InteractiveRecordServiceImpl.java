package com.cn.fehorizon.crm.interactive.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.fehorizon.crm.interactive.daoImpl.InteractiveRecordDaoImpl;
import com.cn.fehorizon.crm.interactive.model.InteractionCollecion;
import com.cn.fehorizon.crm.interactive.model.InteractionRecord;
import com.cn.fehorizon.crm.interactive.model.InteractiveRecord;
import com.cn.fehorizon.crm.interactive.service.InteractiveRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:55 PM
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class InteractiveRecordServiceImpl implements InteractiveRecordService {

    @Autowired
    private InteractiveRecordDaoImpl interactiveRecordDaoImpl;

    @Override
    public List<InteractionRecord> findInteractionRecordList(JSONObject json) {

        List<InteractionRecord> list = null;

        StringBuilder sb = new StringBuilder("select case `data_source` " +
                "when '01' then 'CRM' when '02' then 'WPS' when '03' then 'ERP' when '04' then '微信小程序' when '99' then '外部数据' when NULL then 'null' end as `data_source`, " +
                "`event_type_sub`, `event`, `event_type`, `personnel`, `happen_time`, `sale_phone`, `receipt_number` from `interactive_record` where ");

        Long visitID = json.getLong("visitId");
        String creator = json.getString("creator");
        Integer permission = json.getInteger("permission");
        Long contactId = json.getLong("contactId");
        String eventType = json.getString("eventType");

        if (contactId != null) {
            if (contactId == 0) {
                sb.append(" `visit_id` = " + visitID + " and");
            } else if (contactId > 0) {
                sb.append(" `visit_id` = " + visitID + " and `contact_id` = " + contactId + " and");
            }
        } else {
            sb.append(" `visit_id` = " + visitID + " and");
        }

        if (StringUtils.isNotBlank(eventType)) {
            sb.append(" `event_type` = " + eventType + " and");
        }

        if (permission == 0) {
            sb.append(" `creator` = '" + creator + "' and");
        }

        String sql = sb.substring(0, sb.lastIndexOf("and")) + " order by `cDate` desc;";

        list = interactiveRecordDaoImpl.findInteractionRecordList(sql);

        return list;
    }


    @Override
    public List<InteractionCollecion> findInteractionCollecionList(JSONObject json) {

        List<InteractionCollecion> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder("select case `data_source` " +
                "when '01' then 'CRM' when '02' then 'WPS' when '03' then 'ERP' when '04' then '微信小程序' when '99' then '外部数据' when NULL then 'null' end as `data_source`, " +
                "`visit_id`, `contact_id`, `event_type_sub`, `event`, `event_type`, `personnel`, `happen_time`, `sale_phone`, `receipt_number` from `interactive_record` where ");

        String creator = json.getString("creator");
        Integer permission = json.getInteger("permission");
        String eventType = json.getString("eventType");
        JSONArray queryObjIds = json.getJSONArray("queryObjIds");


        if (StringUtils.isNotBlank(eventType)) {
            sb.append(" `event_type` = " + eventType + " and");
        }

        if (permission == 0) {
            sb.append(" `creator` = '" + creator + "' and");
        }

        if (queryObjIds.size() > 0) {
            for (int i = 0; i < queryObjIds.size(); i++) {
                JSONObject query = queryObjIds.getJSONObject(i);
                Long visitId = query.getLong("visitId");
                Long contactId = query.getLong("contactId");
                List<InteractionCollecion> result = null;
                if (contactId != null) {
                    if (contactId == 0) {
                        String sub = sb.toString() + " `visit_id` = " + visitId + " and";
                        String sql = sub.substring(0, sub.lastIndexOf("and")) + " order by `cDate` desc limit 1;";
                        result = interactiveRecordDaoImpl.findInteractionCollecionList(sql);
                    } else if (contactId > 0) {
                        String sub = sb.toString() + " `visit_id` = " + visitId + " and `contact_id` = " + contactId + " and";
                        String sql = sub.substring(0, sub.lastIndexOf("and")) + " order by `cDate` desc limit 1;";
                        result = interactiveRecordDaoImpl.findInteractionCollecionList(sql);
                    }

                } else {
                    String sub = sb.toString() + " `visit_id` = " + visitId + " and";
                    String sql = sub.substring(0, sub.lastIndexOf("and")) + " order by `cDate` desc limit 1;";
                    result = interactiveRecordDaoImpl.findInteractionCollecionList(sql);
                }

                if (result != null && result.size() > 0) {
                    list.add(result.get(0));
                }

            }
        }
        return list;
    }

    @Override
    public void insert(InteractiveRecord interactiveRecord) {
        interactiveRecordDaoImpl.insert(interactiveRecord);
    }


}
