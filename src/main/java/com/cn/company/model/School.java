package com.cn.company.model;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/02/07 10:12 PM
 * @Description:
 * @Version: 1.0.0
 */
public class School {

    private int id;
    private String name;
    private String modId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", modId='" + modId + '\'' +
                '}';
    }
}
