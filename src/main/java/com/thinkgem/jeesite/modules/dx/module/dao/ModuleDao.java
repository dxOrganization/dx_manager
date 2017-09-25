/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.module.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.module.entity.Module;

/**
 * 版块信息维护DAO接口
 * @author mzh143
 * @version 2017-09-25
 */
@MyBatisDao
public interface ModuleDao extends CrudDao<Module> {
	
}