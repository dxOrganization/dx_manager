/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.channel.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.channel.entity.Channel;

/**
 * 渠道信息DAO接口
 * @author mzh143
 * @version 2017-10-09
 */
@MyBatisDao
public interface ChannelDao extends CrudDao<Channel> {
	
}