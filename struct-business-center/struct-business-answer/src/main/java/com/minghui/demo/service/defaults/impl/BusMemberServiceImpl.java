package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.BusMemberDAO;
import com.minghui.demo.entity.defaults.model.BusMember;
import com.minghui.demo.entity.defaults.model.BusMemberExample;
import com.minghui.demo.service.defaults.BusMemberService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 用户表服务实现类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
@Service("busMemberService")
public class BusMemberServiceImpl extends BaseServiceImpl<Long, BusMember, BusMemberExample, BusMemberDAO> implements BusMemberService {


    /**
     * 用户表批量插入
     * @param records 用户表对象列表
     * @return 成功插入用户表数量
     * @author ThinkPad 2020-08-20 14:17
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<BusMember> records) {
        for (BusMember record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}