package com.ropeok.db.util;

/**
 * @Classname:DataSourceHolder
 * @Auther:chenqinglin
 * @Date:2018/12/14 17:39
 * @Version: 1.0
 */
public class DataSourceHolder {

    private static final ThreadLocal<DataSourceKey> dataSourceKey = new ThreadLocal<>();

    public static DataSourceKey getDataSourceKey() {
        return dataSourceKey.get();
    }

    public static void setDataSourceKey(DataSourceKey type) {
        dataSourceKey.set(type);
    }

    public static void clearDataSourceKey() {
        dataSourceKey.remove();
    }
}
