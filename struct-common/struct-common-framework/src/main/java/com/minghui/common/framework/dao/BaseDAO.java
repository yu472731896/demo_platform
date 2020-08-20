package com.minghui.common.framework.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<PK, Model, Example> {

    int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

    List<Model> selectByExample(Example example);

    Model selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") Example example);

    int updateByExample(@Param("record") Model record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);

    List<Model> selectByExampleWithBLOBs(Example example);
}
