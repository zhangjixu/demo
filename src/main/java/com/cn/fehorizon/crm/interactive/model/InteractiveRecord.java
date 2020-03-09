package com.cn.fehorizon.crm.interactive.model;


import java.sql.Timestamp;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:09 PM
 * @Description:
 * @Version: 1.0.0
 */
public class InteractiveRecord {

    // 主键 自增
    private int id;
    // 客户联系人 ID
    private long contactId;
    // 拜访对象 ID
    private long visitId;
    // 数据来源
    private String dataSource;
    // 发生时间
    private Timestamp happenTime;
    // 人员
    private String personnel;
    // 事件
    private String event;
    // 时间类型
    private String eventType;
    // 时间类型子类
    private String eventTypeSub;
    // 员工 ID
    private String employeeID;
    // 所属事业部 ID
    private String unitID;
    // 所属营业店 ID
    private String shopID;
    // 创建人
    private String creator;
    // 业务员手机
    private String salePhone;
    // 单据编号
    private String receiptNumber;
    // 创建时间
    private Timestamp cDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getVisitId() {
        return visitId;
    }

    public void setVisitId(long visitId) {
        this.visitId = visitId;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Timestamp getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Timestamp happenTime) {
        this.happenTime = happenTime;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeSub() {
        return eventTypeSub;
    }

    public void setEventTypeSub(String eventTypeSub) {
        this.eventTypeSub = eventTypeSub;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSalePhone() {
        return salePhone;
    }

    public void setSalePhone(String salePhone) {
        this.salePhone = salePhone;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public Timestamp getcDate() {
        return cDate;
    }

    public void setcDate(Timestamp cDate) {
        this.cDate = cDate;
    }


}
