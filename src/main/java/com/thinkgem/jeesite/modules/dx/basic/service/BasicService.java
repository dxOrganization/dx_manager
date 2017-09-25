/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dx.basic.entity.Basic;
import com.thinkgem.jeesite.modules.dx.basic.dao.BasicDao;

/**
 * 基础设置Service
 * @author mzh143
 * @version 2017-09-25
 */
@Service
@Transactional(readOnly = true)
public class BasicService extends CrudService<BasicDao, Basic> {

	public Basic get(String id) {
		return super.get(id);
	}
	
	public List<Basic> findList(Basic basic) {
		return super.findList(basic);
	}
	
	public Page<Basic> findPage(Page<Basic> page, Basic basic) {
		return super.findPage(page, basic);
	}
	
	@Transactional(readOnly = false)
	public void save(Basic basic) {
		super.save(basic);
	}
	
	@Transactional(readOnly = false)
	public void delete(Basic basic) {
		super.delete(basic);
	}
	
}