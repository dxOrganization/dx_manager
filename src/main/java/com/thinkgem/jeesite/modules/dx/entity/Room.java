package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 直播间维护表
 * @author lei.c
 * @create 2017-09-24 14:50:19
 */
public class Room implements Serializable {

    private static final long serialVersionUID = 8741563055638260L;

    private Long id;//主键

    private String roomName;//直播间名称

    private String headImageUrl;//直播间头像图片URL地址

    private String imageUrl;//直播间展示图片URL地址

    private String type;//直播间类型名称 唱歌；游戏；聊天；一对一；一对多；（暂定这五个类型）

    private Integer status;//直播间状态 0:即将开始；1:直播中；2:已关闭；默认0

    private Integer payment;//进入直播间消耗金币数量

    private String city;//直播间所在城市

    private String videoUrl;//直播间视频URL

    private Long moduleId;//直播间所属版块ID

    private Date created;//创建时间

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getHeadImageUrl() {
        return this.headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayment() {
        return this.payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
