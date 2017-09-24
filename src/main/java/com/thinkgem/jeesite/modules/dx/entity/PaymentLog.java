package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员消费日志表
 * @author lei.c
 * @create 2017-09-24 14:50:19
 */
public class PaymentLog implements Serializable {

    private static final long serialVersionUID = 9000588293367218L;

    private Long id;//主键

    private Long memberId;//用户ID

    private Integer type;//消费类型 0:观看直播；

    private Long roomId;//直播间ID

    private Integer payment;//消费金币数量

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

    public Long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getPayment() {
        return this.payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
