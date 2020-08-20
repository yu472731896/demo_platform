package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 题目实体类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusQuestionBank extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7579048757885138944L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 主键
     */
    private Long tBId;

    /**
     * 题目归属主键
     */
    private Long questionClassId;

    /**
     * 题目主题
     */
    private String body;

    /**
     * 题目类型，1：单选 2：多选
     */
    private Integer type;
}