package com.cn.company.model;


/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:11 PM
 * @Description:
 * @Version: 1.0.0
 */
public class TShardingMetainfo {

    private int id;
    private String shardType;
    private String shardValue;
    private int tDbId;
    private String cDate;
    private String cBy;
    private String uDate;
    private String uBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShardType() {
        return shardType;
    }

    public void setShardType(String shardType) {
        this.shardType = shardType;
    }

    public String getShardValue() {
        return shardValue;
    }

    public void setShardValue(String shardValue) {
        this.shardValue = shardValue;
    }

    public int gettDbId() {
        return tDbId;
    }

    public void settDbId(int tDbId) {
        this.tDbId = tDbId;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public String getcBy() {
        return cBy;
    }

    public void setcBy(String cBy) {
        this.cBy = cBy;
    }

    public String getuDate() {
        return uDate;
    }

    public void setuDate(String uDate) {
        this.uDate = uDate;
    }

    public String getuBy() {
        return uBy;
    }

    public void setuBy(String uBy) {
        this.uBy = uBy;
    }
}
