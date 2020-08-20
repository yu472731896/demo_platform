package com.minghui.common.framework.impl;

import com.github.pagehelper.PageHelper;
import com.minghui.common.framework.dao.BaseDAO;
import com.minghui.common.framework.model.BaseExample;
import com.minghui.common.framework.model.BaseModel;
import com.minghui.common.framework.service.BaseService;
import com.minghui.util.LoginUserInfo;
import com.minghui.util.utils.RequestAndResponseContextUtils;
import com.minghui.util.utils.SSOUserUtils;
import com.minghui.util.utils.ServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<PK extends Serializable, Model extends BaseModel, Example extends BaseExample, DAO extends BaseDAO<PK, Model, Example>>
		implements BaseService<PK, Model, Example, DAO> {

	@Autowired
	private DAO dao;
	
	protected DAO getDAO() {
		if (this.dao == null) {
			throw new NullPointerException("dao is null!");
		}
		return this.dao;
	}

    @Override
    public int countByExample(Example example) {
    	return getDAO().countByExample(example);
    }

    @Override
    public int deleteByExample(Example example) {
    	return getDAO().deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(PK id) {
    	return getDAO().deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Model record) {
        record = transforInsertModel(record);
    	return getDAO().insert(record);
    }

    public int insertBatch(List<Model> records) {
        int count = 0;
        for (Model record : records) {
            count += insert(record);
        }
        return count;
    }

    @Override
    public int insertSelective(Model record) {
        record = transforInsertModel(record);
    	return getDAO().insertSelective(record);
    }

    @Override
    public List<Model> selectByExample(Example example) {
    	return getDAO().selectByExample(example);
    }

    @Override
    public List<Model> selectPageByExample(Example example){
        Assert.notNull(example.getPager(),"pager is null.");
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(example.getPager().getPageId(),example.getPager().getPageSize(),example.getPager().isCount());
        return selectByExample(example);
    }

    /**
     * 含大字段列表查询
     * @param example 查询参数
     * @return 数据列表
     * @author lhp 2020-06-13 15:52:26
     * @since 1.0.0
     */
    public List<Model> selectByExampleWithBLOBs(Example example) {
    	return getDAO().selectByExampleWithBLOBs(example);
    }

    /**
     * 含大字段分页查询
     * @param example 查询参数
     * @return 数据列表
     * @author lhp 2020-06-13 15:52:41
     * @since 1.0.0
     */
    public List<Model> selectPageByExampleWithBLOBs(Example example){
        Assert.notNull(example.getPager(),"pager is null.");
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(example.getPager().getPageId(),example.getPager().getPageSize(),example.getPager().isCount());
        return selectByExampleWithBLOBs(example);
    }

    @Override
    public Model selectByPrimaryKey(PK id) {
    	return getDAO().selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Model record, Example example) {
        record = transforUpdateModel(record);
    	return getDAO().updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Model record, Example example) {
        record = transforUpdateModel(record);
    	return getDAO().updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Model record) {
        record = transforUpdateModel(record);
	    return getDAO().updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Model record) {
        record = transforUpdateModel(record);
    	return getDAO().updateByPrimaryKey(record);
    }

    public int updateByExampleSelectiveNoVersion(Model record, Example example) {
        record = transforUpdateModel(record);
        return getDAO().updateByExampleSelective(record, example);
    }

    public int updateByExampleNoVersion(Model record, Example example) {
        record = transforUpdateModel(record);
        return getDAO().updateByExample(record, example);
    }

    public int updateByPrimaryKeySelectiveNoVersion(Model record) {
        record = transforUpdateModel(record);
        return getDAO().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKeyNoVersion(Model record) {
        record = transforUpdateModel(record);
        return getDAO().updateByPrimaryKey(record);
    }

    protected Model transforUpdateModel(Model record) {
        String address = ServletUtils.getHostIP();
        record.setUpdateServerHost(address);
        record.setUpdateTime(new Date());
        LoginUserInfo loginUserInfo = SSOUserUtils.getLoginUserInfo();
        if (loginUserInfo != null) {
            record.setUpdateUser(loginUserInfo.getUsername());
            record.setUpdateDepartment(loginUserInfo.getDepartmentNo());
        } else {
            if (StringUtils.isBlank(record.getUpdateUser())) {
                String userOrAddress = ServletUtils.getIpAddr(RequestAndResponseContextUtils.request());
                if (StringUtils.isNotBlank(userOrAddress)) {
                    record.setUpdateUser(userOrAddress);
                } else {
                    record.setUpdateUser(ServletUtils.getHostName());
                }
            }
        }
        return record;
    }

    protected Model transforInsertModel(Model record) {
        String address = ServletUtils.getHostIP();
        record.setCreateServerHost(address);
        Date nowDate = new Date();
        record.setCreateTime(nowDate);
        record.setUpdateTime(nowDate);
        LoginUserInfo loginUserInfo = SSOUserUtils.getLoginUserInfo();
        if (loginUserInfo != null) {
            record.setCreateUser(loginUserInfo.getUsername());
            record.setCreateDepartment(loginUserInfo.getDepartmentNo());
        } else {
            if (StringUtils.isBlank(record.getCreateUser())) {
                String userOrAddress = ServletUtils.getIpAddr(RequestAndResponseContextUtils.request());
                if (StringUtils.isNotBlank(userOrAddress)) {
                    record.setCreateUser(userOrAddress);
                } else {
                    record.setCreateUser(ServletUtils.getHostName());
                }
            }
        }
        // 增加设置版本号，新增对象可直接用于后续更新操作
        record.setRecordVersion(0);
        // 增加是否删除标记
        record.setIsDelete(false);
        return record;
    }

}
