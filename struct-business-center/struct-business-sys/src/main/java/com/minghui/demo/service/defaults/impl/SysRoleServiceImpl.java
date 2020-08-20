package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.SysRoleDAO;
import com.minghui.demo.entity.defaults.model.SysRole;
import com.minghui.demo.entity.defaults.model.SysRoleExample;
import com.minghui.demo.service.defaults.SysRoleService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 后台用户角色表服务实现类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<Long, SysRole, SysRoleExample, SysRoleDAO> implements SysRoleService {


    /**
     * 后台用户角色表批量插入
     * @param records 后台用户角色表对象列表
     * @return 成功插入后台用户角色表数量
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<SysRole> records) {
        for (SysRole record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}