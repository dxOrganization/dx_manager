package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 订单主表
 * @author lei.c
 * @since 1.0,2017-09-24 14:50:19
 */
public class Order implements Serializable {

    private static final long serialVersionUID = 1589559785589113L;

    private Long id;//主键

    private String orderNum;//订单编号(年月日＋8位随机数)(加唯一索引，代码中cach异常，捕获后重新调用生成编号，再插入)

    private Long memberId;//用户ID

    private Integer paymentType;//付款方式 0:微信；1:支付宝；2:转账；

    private BigDecimal payment;//订单金额（2位小数）

    private Integer type;//订单类型 0:充值金币；1:开通VIP；

    private Date created;//创建时间

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPayment() {
        return this.payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
