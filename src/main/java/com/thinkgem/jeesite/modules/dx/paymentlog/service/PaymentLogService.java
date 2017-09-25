/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.paymentlog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.dx.paymentlog.entity.PaymentLog;
import com.thinkgem.jeesite.modules.dx.paymentlog.dao.PaymentLogDao;

/**
 * 会员消费记录Service
 * @author mzh143
 * @version 2017-09-25
 */
@Service
@Transactional(readOnly = true)
public class PaymentLogService extends CrudService<PaymentLogDao, PaymentLog> {

	public PaymentLog get(String id) {
		return super.get(id);
	}
	
	public List<PaymentLog> findList(PaymentLog paymentLog) {
		return super.findList(paymentLog);
	}
	
	public Page<PaymentLog> findPage(Page<PaymentLog> page, PaymentLog paymentLog) {
		return super.findPage(page, paymentLog);
	}
	
	@Transactional(readOnly = false)
	public void save(PaymentLog paymentLog) {
		super.save(paymentLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(PaymentLog paymentLog) {
		super.delete(paymentLog);
	}
	
}