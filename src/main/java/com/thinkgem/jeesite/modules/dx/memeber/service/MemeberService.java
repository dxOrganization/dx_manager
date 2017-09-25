/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.memeber.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dx.memeber.entity.Memeber;
import com.thinkgem.jeesite.modules.dx.memeber.dao.MemeberDao;

/**
 * 会员信息Service
 * @author mzh143
 * @version 2017-09-25
 */
@Service
@Transactional(readOnly = true)
public class MemeberService extends CrudService<MemeberDao, Memeber> {

	public Memeber get(String id) {
		return super.get(id);
	}
	
	public List<Memeber> findList(Memeber memeber) {
		return super.findList(memeber);
	}
	
	public Page<Memeber> findPage(Page<Memeber> page, Memeber memeber) {
		return super.findPage(page, memeber);
	}
	
	@Transactional(readOnly = false)
	public void save(Memeber memeber) {
		super.save(memeber);
	}
	
	@Transactional(readOnly = false)
	public void delete(Memeber memeber) {
		super.delete(memeber);
	}
	
}