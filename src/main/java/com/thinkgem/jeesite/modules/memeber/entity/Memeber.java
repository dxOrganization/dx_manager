/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.memeber.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 会员信息Entity
 * @author mzh143
 * @version 2017-09-24
 */
public class Memeber extends DataEntity<Memeber> {
	
	private static final long serialVersionUID = 1L;
	private String mobile;		// 手机号
	private String nickName;		// 用户昵称
	private String type;		// 用户类型
	private String source;		// 用户来源
	private String headImageUrl;		// 用户头像
	private Long channelId;		// 渠道
	private String channelName;		// 渠道名称
	private String recommendUid;		// 推荐人
	private String score;		// 用户积分
	private String gold;		// 金币总数量
	private Date vipTime;		// 成为会员时间
	private Date created;		// 创建时间
	
	public Memeber() {
		super();
	}

	public Memeber(String id){
		super(id);
	}

	@Length(min=0, max=20, message="手机号长度必须介于 0 和 20 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=60, message="用户昵称长度必须介于 0 和 60 之间")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Length(min=0, max=4, message="用户类型长度必须介于 0 和 4 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=4, message="用户来源长度必须介于 0 和 4 之间")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Length(min=0, max=200, message="用户头像长度必须介于 0 和 200 之间")
	public String getHeadImageUrl() {
		return headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}
	
	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	@Length(min=0, max=30, message="渠道名称长度必须介于 0 和 30 之间")
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	@Length(min=0, max=30, message="推荐人长度必须介于 0 和 30 之间")
	public String getRecommendUid() {
		return recommendUid;
	}

	public void setRecommendUid(String recommendUid) {
		this.recommendUid = recommendUid;
	}
	
	@Length(min=0, max=20, message="用户积分长度必须介于 0 和 20 之间")
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Length(min=0, max=20, message="金币总数量长度必须介于 0 和 20 之间")
	public String getGold() {
		return gold;
	}

	public void setGold(String gold) {
		this.gold = gold;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getVipTime() {
		return vipTime;
	}

	public void setVipTime(Date vipTime) {
		this.vipTime = vipTime;
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