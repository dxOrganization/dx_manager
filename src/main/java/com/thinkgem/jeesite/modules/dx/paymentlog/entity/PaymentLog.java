/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.paymentlog.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会员消费记录Entity
 * @author mzh143
 * @version 2017-10-10
 */
public class PaymentLog extends DataEntity<PaymentLog> {
	
	private static final long serialVersionUID = 1L;
	private String memberId;		// 用户
	private String type;		// 消费类型
	private String roomId;		// 直播间
	private String payment;		// 消费金币数量
	private Date created;		// 创建时间
	
	public PaymentLog() {
		super();
	}

	public PaymentLog(String id){
		super(id);
	}

	@Length(min=0, max=20, message="用户长度必须介于 0 和 20 之间")
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Length(min=0, max=4, message="消费类型长度必须介于 0 和 4 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=20, message="直播间长度必须介于 0 和 20 之间")
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	
	@Length(min=0, max=11, message="消费金币数量长度必须介于 0 和 11 之间")
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}