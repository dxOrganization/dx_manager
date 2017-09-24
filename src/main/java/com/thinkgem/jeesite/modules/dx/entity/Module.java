package com.thinkgem.jeesite.modules.dx.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 版块维护基础表
 * @author lei.c
 * @create 2017-09-24 14:50:19
 */
public class Module implements Serializable {

    private static final long serialVersionUID = 4364996815345267L;

    private Long id;//主键

    private String moduleName;//版块名称

    private String moduleImageUrl;//版块图片URL地址

    private Integer isview;//是否显示 0:显示；1:不显示；默认0

    private Date created;//创建时间

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleImageUrl() {
        return this.moduleImageUrl;
    }

    public void setModuleImageUrl(String moduleImageUrl) {
        this.moduleImageUrl = moduleImageUrl;
    }

    public Integer getIsview() {
        return this.isview;
    }

    public void setIsview(Integer isview) {
        this.isview = isview;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
