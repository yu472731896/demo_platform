package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.SysUserDAO;
import com.minghui.demo.entity.defaults.model.SysUser;
import com.minghui.demo.entity.defaults.model.SysUserExample;
import com.minghui.demo.service.defaults.SysUserService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 后台用户表服务实现类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<Long, SysUser, SysUserExample, SysUserDAO> implements SysUserService {


    /**
     * 后台用户表批量插入
     * @param records 后台用户表对象列表
     * @return 成功插入后台用户表数量
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<SysUser> records) {
        for (SysUser record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}