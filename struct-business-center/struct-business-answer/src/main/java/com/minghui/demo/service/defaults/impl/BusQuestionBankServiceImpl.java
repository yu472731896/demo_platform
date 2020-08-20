package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.BusQuestionBankDAO;
import com.minghui.demo.entity.defaults.model.BusQuestionBank;
import com.minghui.demo.entity.defaults.model.BusQuestionBankExample;
import com.minghui.demo.service.defaults.BusQuestionBankService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 题目服务实现类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Service("busQuestionBankService")
public class BusQuestionBankServiceImpl extends BaseServiceImpl<Long, BusQuestionBank, BusQuestionBankExample, BusQuestionBankDAO> implements BusQuestionBankService {


    /**
     * 题目批量插入
     * @param records 题目对象列表
     * @return 成功插入题目数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<BusQuestionBank> records) {
        for (BusQuestionBank record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}