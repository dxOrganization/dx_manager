/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.dx.entity.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2017-10-09
 */
public class Basic extends DataEntity<Basic> {
	
	private static final long serialVersionUID = 1L;
	private String open;		// 网站开关
	private String closeUrl;		// 网站关闭后跳转URL
	private String computer;		// 是否允许电脑访问 0:允许；1:不允许；默认1
	private String computerUrl;		// 电脑访问跳转页面URL
	
	public Basic() {
		super();
	}

	public Basic(String id){
		super(id);
	}

	@Length(min=0, max=4, message="网站开关长度必须介于 0 和 4 之间")
	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
	
	@Length(min=0, max=200, message="网站关闭后跳转URL长度必须介于 0 和 200 之间")
	public String getCloseUrl() {
		return closeUrl;
	}

	public void setCloseUrl(String closeUrl) {
		this.closeUrl = closeUrl;
	}
	
	@Length(min=0, max=4, message="是否允许电脑访问 0:允许；1:不允许；默认1长度必须介于 0 和 4 之间")
	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}
	
	@Length(min=0, max=200, message="电脑访问跳转页面URL长度必须介于 0 和 200 之间")
	public String getComputerUrl() {
		return computerUrl;
	}

	public void setComputerUrl(String computerUrl) {
		this.computerUrl = computerUrl;
	}
	
}