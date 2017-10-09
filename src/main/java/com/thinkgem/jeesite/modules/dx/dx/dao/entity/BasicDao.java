/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.dx.dao.entity;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.dx.entity.entity.Basic;

/**
 * 单表生成DAO接口
 * @author ThinkGem
 * @version 2017-10-09
 */
@MyBatisDao
public interface BasicDao extends CrudDao<Basic> {
	
}