package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.BusAnswerDAO;
import com.minghui.demo.entity.defaults.model.BusAnswer;
import com.minghui.demo.entity.defaults.model.BusAnswerExample;
import com.minghui.demo.service.defaults.BusAnswerService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 答案服务实现类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Service("busAnswerService")
public class BusAnswerServiceImpl extends BaseServiceImpl<Long, BusAnswer, BusAnswerExample, BusAnswerDAO> implements BusAnswerService {


    /**
     * 答案批量插入
     * @param records 答案对象列表
     * @return 成功插入答案数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<BusAnswer> records) {
        for (BusAnswer record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}