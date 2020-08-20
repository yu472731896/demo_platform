package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.SysPermissionDAO;
import com.minghui.demo.entity.defaults.model.SysPermission;
import com.minghui.demo.entity.defaults.model.SysPermissionExample;
import com.minghui.demo.service.defaults.SysPermissionService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 后台用户权限表服务实现类
 * @author ThinkPad 2020-08-18 11:46
 * @since 1.0.0
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends BaseServiceImpl<Long, SysPermission, SysPermissionExample, SysPermissionDAO> implements SysPermissionService {


    /**
     * 后台用户权限表批量插入
     * @param records 后台用户权限表对象列表
     * @return 成功插入后台用户权限表数量
     * @author ThinkPad 2020-08-18 11:46
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<SysPermission> records) {
        for (SysPermission record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}