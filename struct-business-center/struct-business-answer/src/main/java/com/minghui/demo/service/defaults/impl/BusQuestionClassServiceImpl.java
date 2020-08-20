package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.BusQuestionClassDAO;
import com.minghui.demo.entity.defaults.model.BusQuestionClass;
import com.minghui.demo.entity.defaults.model.BusQuestionClassExample;
import com.minghui.demo.service.defaults.BusQuestionClassService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 题目类别服务实现类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Service("busQuestionClassService")
public class BusQuestionClassServiceImpl extends BaseServiceImpl<Long, BusQuestionClass, BusQuestionClassExample, BusQuestionClassDAO> implements BusQuestionClassService {


    /**
     * 题目类别批量插入
     * @param records 题目类别对象列表
     * @return 成功插入题目类别数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<BusQuestionClass> records) {
        for (BusQuestionClass record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}