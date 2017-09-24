package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 渠道维护表
 * @author lei.c
 * @create 2017-09-24 14:50:19
 */
public class Channel implements Serializable {

    private static final long serialVersionUID = 3962672898412857L;

    private Long id;//主键

    private String channelName;//渠道名称

    private String manager;//渠道负责人（手动录入，比如张三的渠道）

    private Date created;//创建时间

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getManager() {
        return this.manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
