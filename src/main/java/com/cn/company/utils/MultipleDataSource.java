package com.cn.company.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/6/11
 * @Description:
 * @Version: 1.0.0
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
    /**
     * 注意：数据源标识保存在线程变量中，避免多线程操作数据源时互相干扰
     */
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static void setDatabase(int id) {
        if (id == 1) {
            MultipleDataSource.setDataSourceKey("db1");
        } else if (id == 2) {
            MultipleDataSource.setDataSourceKey("db2");
        }
    }

}
