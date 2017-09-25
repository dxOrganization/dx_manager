/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.channel.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 渠道信息Entity
 * @author mzh143
 * @version 2017-09-25
 */
public class Channel extends DataEntity<Channel> {
	
	private static final long serialVersionUID = 1L;
	private String channelName;		// 渠道名称
	private String manager;		// 渠道负责人
	private Date created;		// 创建时间
	
	public Channel() {
		super();
	}

	public Channel(String id){
		super(id);
	}

	@Length(min=0, max=60, message="渠道名称长度必须介于 0 和 60 之间")
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	@Length(min=0, max=60, message="渠道负责人长度必须介于 0 和 60 之间")
	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}