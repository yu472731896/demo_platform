package com.minghui.demo.entity.defaults.model;

import com.minghui.common.framework.model.BaseModel;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 答题记录实体类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusAnswerRecord extends BaseModel implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 6498588090104480768L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户主键
     */
    private Long memberId;

    /**
     * 题目主键
     */
    private Long questionId;

    /**
     * 是否回答正确
     */
    private Boolean isCorrectly;

    /**
     * 答题记录
     */
    private String answerRecord;

    /**
     * 正确答案
     */
    private String questionAnswer;
}