package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;

/**
 * 基础设置表
 * @author lei.c
 * @create 2017-09-24 14:50:19
 */
public class Basic implements Serializable {

    private static final long serialVersionUID = 4022102237166931L;

    private Long id;//主键

    private Integer open;//网站开关 0:打开；1:关闭；默认0

    private String closeUrl;//网站关闭后跳转URL

    private Integer computer;//是否允许电脑访问 0:允许；1:不允许；默认1

    private String computerUrl;//电脑访问跳转页面URL

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOpen() {
        return this.open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public String getCloseUrl() {
        return this.closeUrl;
    }

    public void setCloseUrl(String closeUrl) {
        this.closeUrl = closeUrl;
    }

    public Integer getComputer() {
        return this.computer;
    }

    public void setComputer(Integer computer) {
        this.computer = computer;
    }

    public String getComputerUrl() {
        return this.computerUrl;
    }

    public void setComputerUrl(String computerUrl) {
        this.computerUrl = computerUrl;
    }

}
