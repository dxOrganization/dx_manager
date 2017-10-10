/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.complaint.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.dx.complaint.entity.Complaint;

/**
 * 会议投诉建议DAO接口
 * @author mzh143
 * @version 2017-10-10
 */
@MyBatisDao
public interface ComplaintDao extends CrudDao<Complaint> {
	
}