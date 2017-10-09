/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.module.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 版块信息维护Entity
 * @author mzh143
 * @version 2017-10-09
 */
public class Module extends DataEntity<Module> {
	
	private static final long serialVersionUID = 1L;
	private String moduleName;		// 版块名称
	private String moduleImageUrl;		// 版块图片
	private String isview;		// 是否显示
	private Date created;		// 创建时间
	
	public Module() {
		super();
	}

	public Module(String id){
		super(id);
	}

	@Length(min=0, max=30, message="版块名称长度必须介于 0 和 30 之间")
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Length(min=0, max=200, message="版块图片长度必须介于 0 和 200 之间")
	public String getModuleImageUrl() {
		return moduleImageUrl;
	}

	public void setModuleImageUrl(String moduleImageUrl) {
		this.moduleImageUrl = moduleImageUrl;
	}
	
	@Length(min=0, max=4, message="是否显示长度必须介于 0 和 4 之间")
	public String getIsview() {
		return isview;
	}

	public void setIsview(String isview) {
		this.isview = isview;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}