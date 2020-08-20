package com.minghui.common.framework.page;

import java.util.List;

import lombok.Data;

/**
 * eazyui列表分页查询结果
 * @author zjk
 *
 * @param <T>
 */
@Data
public class PageDataGrid<T> {

	/**
	 * 总记录数据
	 */
	private Integer total;
	
	/**
	 * 分页查询的数据集
	 */
	private List<T> list;

}
