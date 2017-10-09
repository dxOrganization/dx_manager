/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.complaint.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dx.complaint.entity.Complaint;
import com.thinkgem.jeesite.modules.dx.complaint.dao.ComplaintDao;

/**
 * 会议投诉建议Service
 * @author mzh143
 * @version 2017-10-09
 */
@Service
@Transactional(readOnly = true)
public class ComplaintService extends CrudService<ComplaintDao, Complaint> {

	public Complaint get(String id) {
		return super.get(id);
	}
	
	public List<Complaint> findList(Complaint complaint) {
		return super.findList(complaint);
	}
	
	public Page<Complaint> findPage(Page<Complaint> page, Complaint complaint) {
		return super.findPage(page, complaint);
	}
	
	@Transactional(readOnly = false)
	public void save(Complaint complaint) {
		super.save(complaint);
	}
	
	@Transactional(readOnly = false)
	public void delete(Complaint complaint) {
		super.delete(complaint);
	}
	
}