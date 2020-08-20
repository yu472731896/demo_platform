package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.BusQuestionBankDAO;
import com.minghui.demo.entity.defaults.model.BusQuestionBank;
import com.minghui.demo.entity.defaults.model.BusQuestionBankExample;

/**
 * 题目服务类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusQuestionBankService extends BaseService<Long, BusQuestionBank, BusQuestionBankExample, BusQuestionBankDAO> {
}