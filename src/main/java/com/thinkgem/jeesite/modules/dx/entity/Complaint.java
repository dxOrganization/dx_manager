package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员投诉建议表
 * @author lei.c
 * @create 2017-09-24 14:50:19
 */
public class Complaint implements Serializable {

    private static final long serialVersionUID = 6439176249482275L;

    private Long id;//主键

    private Long memberId;//会员ID

    private Integer type;//投诉建议类型 0:用户；1:管理员回复；默认0（前台区分显示时使用）

    private String remark;//投诉建议内容（限制在250字以内）

    private Date created;//创建时间

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
