/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.order.entity;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.memeber.entity.Memeber;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 订单信息（充值）Entity
 * @author mzh143
 * @version 2017-09-24
 */
public class Order extends DataEntity<Order> {
	
	private static final long serialVersionUID = 1L;
	private String orderNum;		// 订单编号
	private Memeber memberId;		// 用户ID
	private String paymentType;		// 付款方式
	private String payment;		// 订单金额
	private String type;		// 订单类型
	private Date created;		// 创建时间
	
	public Order() {
		super();
	}

	public Order(String id){
		super(id);
	}

	@Length(min=1, max=20, message="订单编号长度必须介于 1 和 20 之间")
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	public Memeber getMemberId() {
		return memberId;
	}

	public void setMemberId(Memeber memberId) {
		this.memberId = memberId;
	}
	
	@Length(min=0, max=4, message="付款方式长度必须介于 0 和 4 之间")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	@Length(min=0, max=4, message="订单类型长度必须介于 0 和 4 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="创建时间不能为空")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}