/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.room.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 直播间Entity
 * @author mzh143
 * @version 2017-09-24
 */
public class Room extends DataEntity<Room> {
	
	private static final long serialVersionUID = 1L;
	private String roomName;		// 直播间名称
	private String headImageUrl;		// 直播间头像图片
	private String imageUrl;		// 直播间展示图片
	private String type;		// 直播间类型名称
	private String status;		// 直播间状态
	private String payment;		// 进入直播间消耗金币数量
	private String city;		// 直播间所在城市
	private String videoUrl;		// 直播间视频URL
	private Long moduleId;		// 直播间所属版块ID
	private Date created;		// 创建时间
	
	public Room() {
		super();
	}

	public Room(String id){
		super(id);
	}

	@Length(min=0, max=20, message="直播间名称长度必须介于 0 和 20 之间")
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Length(min=0, max=200, message="直播间头像图片长度必须介于 0 和 200 之间")
	public String getHeadImageUrl() {
		return headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	
	@Length(min=0, max=200, message="直播间展示图片长度必须介于 0 和 200 之间")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Length(min=0, max=20, message="直播间类型名称长度必须介于 0 和 20 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=4, message="直播间状态长度必须介于 0 和 4 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=11, message="进入直播间消耗金币数量长度必须介于 0 和 11 之间")
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	@Length(min=0, max=60, message="直播间所在城市长度必须介于 0 和 60 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=200, message="直播间视频URL长度必须介于 0 和 200 之间")
	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
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