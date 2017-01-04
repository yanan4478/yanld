package com.yanld.module.common.dal.dataobject.model;

import java.util.List;

/**
 * 描述：无限级分类－节点信息
 * 作者：袁伟倩
 * 创建日期：2016-12-03/12/3.
 */
public class ShortCut {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 子节点
	 */
	private String code;

	/**
	 * 父节点
	 */
	private String pid;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


}
