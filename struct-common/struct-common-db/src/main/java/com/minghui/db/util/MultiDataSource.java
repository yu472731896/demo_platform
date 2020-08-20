package com.ropeok.db.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname:MultiDataSource
 * @Descriptions: spring动态数据源
 * @Auther:chenqinglin
 * @Date:2018/12/14 17:35
 * @Version: 1.0
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> datasources;


    public MultiDataSource(){
        datasources = new HashMap<>();
        super.setTargetDataSources(datasources);
    }

    public <T extends DataSource> void addDataSource(DataSourceKey key,T data){
        datasources.put(key,data);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSourceKey();
    }
}
