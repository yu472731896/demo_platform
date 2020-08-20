package com.minghui.demo.service.defaults;

import com.minghui.common.framework.service.BaseService;
import com.minghui.demo.entity.defaults.dao.BusMemberDAO;
import com.minghui.demo.entity.defaults.model.BusMember;
import com.minghui.demo.entity.defaults.model.BusMemberExample;

/**
 * 用户表服务类
 * @author ThinkPad 2020-08-20 14:17
 * @since 1.0.0
 */
public interface BusMemberService extends BaseService<Long, BusMember, BusMemberExample, BusMemberDAO> {
}