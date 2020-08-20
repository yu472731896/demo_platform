package com.minghui.common.framework.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseService<PK, Model, Example, DAO> {

     int countByExample(Example example);

     int deleteByExample(Example example);

     int deleteByPrimaryKey(PK id);

     int insert(Model record);

     /**
      * 批量新增
      * @author zjk
      * @date 2019年8月22日上午10:20:18
      * @param records
      * @return
      */
     int insertBatch(List<Model> records);

     int insertSelective(Model record);

     List<Model> selectByExample(Example example);

     List<Model> selectPageByExample(Example example);
     /**
      * 含大字段列表查询
      * @param example 查询参数
     * @return 数据列表
      * @author lhp 2020-06-13 15:52:26
      * @since 1.0.0
      */
     List<Model> selectByExampleWithBLOBs(Example example);
     /**
      * 含大字段分页查询
      * @param example 查询参数
     * @return 数据列表
      * @author lhp 2020-06-13 15:52:41
      * @since 1.0.0
      */
     List<Model> selectPageByExampleWithBLOBs(Example example);

     Model selectByPrimaryKey(PK id);

     int updateByExampleSelective(@Param("record") Model record, @Param("example") Example example);

     int updateByExample(@Param("record") Model record, @Param("example") Example example);

     int updateByPrimaryKeySelective(Model record);

     int updateByPrimaryKey(Model record);

     /**
      * <p>Description:[不进行版本控制的更新方法]</p>
      * Created on 2019/5/7 14:20
      *
      * @param record
      * @param example
      * @return int
      * @author chenql
      */
     int updateByExampleSelectiveNoVersion(@Param("record") Model record, @Param("example") Example example);

     /**
      * <p>Description:[不进行版本控制的更新方法]</p>
      * Created on 2019/5/7 14:20
      *
      * @param record
      * @param example
      * @return int
      * @author chenql
      */
     int updateByExampleNoVersion(@Param("record") Model record, @Param("example") Example example);

     /**
      * <p>Description:[不进行版本控制的更新方法]</p>
      * Created on 2019/5/7 14:20
      *
      * @param record
      * @return int
      * @author chenql
      */
     int updateByPrimaryKeySelectiveNoVersion(Model record);

     /**
      * <p>Description:[不进行版本控制的更新方法]</p>
      * Created on 2019/5/7 14:20
      *
      * @param record
      * @return int
      * @author chenql
      */
     int updateByPrimaryKeyNoVersion(Model record);

}
