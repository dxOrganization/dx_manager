/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dx.complaint.entity;

import com.thinkgem.jeesite.modules.memeber.entity.Memeber;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会议投诉建议Entity
 * @author mzh143
 * @version 2017-09-25
 */
public class Complaint extends DataEntity<Complaint> {
	
	private static final long serialVersionUID = 1L;
	private Memeber memberId;		// 会员
	private String type;		// 投诉建议类型
	private String remark;		// 投诉建议内容
	private Date created;		// 创建时间
	
	public Complaint() {
		super();
	}

	public Complaint(String id){
		super(id);
	}

	public Memeber getMemberId() {
		return memberId;
	}

	public void setMemberId(Memeber memberId) {
		this.memberId = memberId;
	}
	
	@Length(min=0, max=4, message="投诉建议类型长度必须介于 0 和 4 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=500, message="投诉建议内容长度必须介于 0 和 500 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}