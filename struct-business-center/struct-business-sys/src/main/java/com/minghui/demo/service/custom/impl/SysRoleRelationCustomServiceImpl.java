package com.minghui.demo.service.custom.impl;

import com.minghui.demo.entity.custom.dao.SysRoleRelationCustomDao;
import com.minghui.demo.entity.defaults.model.SysPermission;
import com.minghui.demo.service.custom.SysRoleRelationCustomService;
import com.minghui.demo.service.defaults.impl.SysRoleRelationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mh
 * @version 1.0
 * @description TODO
 * @date 2020/8/17 10:56
 **/
@Service
public class SysRoleRelationCustomServiceImpl extends SysRoleRelationServiceImpl implements SysRoleRelationCustomService {

    @Autowired
    private SysRoleRelationCustomDao sysRoleRelationCustomDao;

    @Override
    public List<SysPermission> getPermissionList(Long sysUserId) {
        return sysRoleRelationCustomDao.getPermissionList(sysUserId);
    }
}
