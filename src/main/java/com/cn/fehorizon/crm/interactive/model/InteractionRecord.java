package com.cn.fehorizon.crm.interactive.model;

import java.sql.Timestamp;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/09 3:10 PM
 * @Description:
 * @Version: 1.0.0
 */
public class InteractionRecord {

    private String data_source;
    private String event_type_sub;
    private String event;
    private String event_type;
    private String personnel;
    private Timestamp happen_time;
    private String sale_phone;
    private String receipt_number;

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getEvent_type_sub() {
        return event_type_sub;
    }

    public void setEvent_type_sub(String event_type_sub) {
        this.event_type_sub = event_type_sub;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public Timestamp getHappen_time() {
        return happen_time;
    }

    public void setHappen_time(Timestamp happen_time) {
        this.happen_time = happen_time;
    }

    public String getSale_phone() {
        return sale_phone;
    }

    public void setSale_phone(String sale_phone) {
        this.sale_phone = sale_phone;
    }

    public String getReceipt_number() {
        return receipt_number;
    }

    public void setReceipt_number(String receipt_number) {
        this.receipt_number = receipt_number;
    }
}
