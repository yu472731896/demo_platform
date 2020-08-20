package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 答案实体类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusAnswer extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 2074689642213759488L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 题目主键
     */
    private Long questionId;

    /**
     * 答案主体
     */
    private String body;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否为正确答案
     */
    private Boolean isRight;
}