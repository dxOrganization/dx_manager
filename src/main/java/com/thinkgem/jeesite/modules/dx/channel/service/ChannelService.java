/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.channel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dx.channel.entity.Channel;
import com.thinkgem.jeesite.modules.dx.channel.dao.ChannelDao;

/**
 * 渠道信息Service
 * @author mzh143
 * @version 2017-10-10
 */
@Service
@Transactional(readOnly = true)
public class ChannelService extends CrudService<ChannelDao, Channel> {

	public Channel get(String id) {
		return super.get(id);
	}
	
	public List<Channel> findList(Channel channel) {
		return super.findList(channel);
	}
	
	public Page<Channel> findPage(Page<Channel> page, Channel channel) {
		return super.findPage(page, channel);
	}
	
	@Transactional(readOnly = false)
	public void save(Channel channel) {
		super.save(channel);
	}
	
	@Transactional(readOnly = false)
	public void delete(Channel channel) {
		super.delete(channel);
	}
	
}