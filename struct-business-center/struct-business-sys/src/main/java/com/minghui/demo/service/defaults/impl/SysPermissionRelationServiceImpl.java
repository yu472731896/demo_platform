package com.minghui.demo.service.defaults.impl;

import com.minghui.common.framework.impl.BaseServiceImpl;
import com.minghui.demo.entity.defaults.dao.SysPermissionRelationDAO;
import com.minghui.demo.entity.defaults.model.SysPermissionRelation;
import com.minghui.demo.entity.defaults.model.SysPermissionRelationExample;
import com.minghui.demo.service.defaults.SysPermissionRelationService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)服务实现类
 * @author ThinkPad 2020-08-17 10:38
 * @since 1.0.0
 */
@Service("sysPermissionRelationService")
public class SysPermissionRelationServiceImpl extends BaseServiceImpl<Long, SysPermissionRelation, SysPermissionRelationExample, SysPermissionRelationDAO> implements SysPermissionRelationService {


    /**
     * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)批量插入
     * @param records 后台用户和权限关系表(除角色中定义的权限以外的加减权限)对象列表
     * @return 成功插入后台用户和权限关系表(除角色中定义的权限以外的加减权限)数量
     * @author ThinkPad 2020-08-17 10:38
     * @since 1.0.0
     */
    @Override
    public int insertBatch(List<SysPermissionRelation> records) {
        for (SysPermissionRelation record : records) {
            transforInsertModel(record);
        }
        return getDAO().insertBatch(records);
    }
}