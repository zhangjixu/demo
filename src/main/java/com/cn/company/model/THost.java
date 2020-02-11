package com.cn.company.model;


/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/10 8:10 PM
 * @Description:
 * @Version: 1.0.0
 */
public class THost {

    private int id;
    private String serverIp;
    private String serverName;
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

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
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
