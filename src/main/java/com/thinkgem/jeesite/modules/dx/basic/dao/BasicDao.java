/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.basic.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.basic.entity.Basic;

/**
 * 基础设置DAO接口
 * @author mzh143
 * @version 2017-09-25
 */
@MyBatisDao
public interface BasicDao extends CrudDao<Basic> {
	
}