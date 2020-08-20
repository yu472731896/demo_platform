package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 题目类别实体类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusQuestionClass extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 161797717533894720L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 父节点
     */
    private Long parentId;

    /**
     * 所有父节点，逗号分隔
     */
    private String parentIds;
}