/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.memeber.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.memeber.entity.Memeber;

/**
 * 会员信息DAO接口
 * @author mzh143
 * @version 2017-10-10
 */
@MyBatisDao
public interface MemeberDao extends CrudDao<Memeber> {
	
}