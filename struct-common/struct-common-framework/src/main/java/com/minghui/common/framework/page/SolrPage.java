package com.minghui.common.framework.page;

/**
 * solr分页查询对象
 * @author cwp 2017年8月29日 下午12:04:28
 *
 */
public class SolrPage {

	/**
	 * 页码
	 */
	private int page;
	
	/**
	 * 每页显示行数
	 */
	private int rows;
	
	/**
	 * 是否排序
	 */
	private boolean isSort;
	
	/**
	 * 排序类型
	 */
	private String[] orderType;
	
	/**
	 * 排序字段
	 */
	private String[] orderField;
	
	/**
	 * 是否高亮
	 */
	private boolean isHighLight;
	
	/**
	 * 高亮字段
	 */
	private String[] highLightField;
	
	/**
	 * 查询参数
	 */
	private String queryParam;
	
	private String[] filterQueryParam;

	public int getPage() {
		if(page > 0) {
			page = page - 1;
		}
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public boolean isSort() {
		return isSort;
	}

	public void setSort(boolean isSort) {
		this.isSort = isSort;
	}

	public String[] getOrderType() {
		return orderType;
	}

	public void setOrderType(String[] orderType) {
		this.orderType = orderType;
	}

	public String[] getOrderField() {
		return orderField;
	}

	public void setOrderField(String[] orderField) {
		this.orderField = orderField;
	}

	public boolean isHighLight() {
		return isHighLight;
	}

	public void setHighLight(boolean isHighLight) {
		this.isHighLight = isHighLight;
	}

	public String[] getHighLightField() {
		return highLightField;
	}

	public void setHighLightField(String[] highLightField) {
		this.highLightField = highLightField;
	}

	public String getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}

	public String[] getFilterQueryParam() {
		return filterQueryParam;
	}

	public void setFilterQueryParam(String[] filterQueryParam) {
		this.filterQueryParam = filterQueryParam;
	}

}
