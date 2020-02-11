package com.cn.company.model;


/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:10 PM
 * @Description:
 * @Version: 1.0.0
 */
public class TDB {

    private int id;
    private int tHostId;
    private String port;
    private String dbName;
    private String userName;
    private String userPwd;
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

    public int gettHostId() {
        return tHostId;
    }

    public void settHostId(int tHostId) {
        this.tHostId = tHostId;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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
