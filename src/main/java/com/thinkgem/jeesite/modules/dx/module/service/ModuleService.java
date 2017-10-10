/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.module.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dx.module.entity.Module;
import com.thinkgem.jeesite.modules.dx.module.dao.ModuleDao;

/**
 * 版块信息维护Service
 * @author mzh143
 * @version 2017-10-10
 */
@Service
@Transactional(readOnly = true)
public class ModuleService extends CrudService<ModuleDao, Module> {

	public Module get(String id) {
		return super.get(id);
	}
	
	public List<Module> findList(Module module) {
		return super.findList(module);
	}
	
	public Page<Module> findPage(Page<Module> page, Module module) {
		return super.findPage(page, module);
	}
	
	@Transactional(readOnly = false)
	public void save(Module module) {
		super.save(module);
	}
	
	@Transactional(readOnly = false)
	public void delete(Module module) {
		super.delete(module);
	}
	
}