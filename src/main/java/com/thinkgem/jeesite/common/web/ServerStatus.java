package com.thinkgem.jeesite.common.web;

/**
 * 消息内容及常用消息
 *
 * @auther lei.c
 * @Date 2017-10-10 下午13:47
 */
public enum ServerStatus {

    SUCCESS("0000","成功"),

    UNKNOW_ERROR("1000","服务器繁忙"),
    USER_DEFINITION("1002",""),

    /*2xxx通用code*/
    PARAM_NOT_NULL("2001","参数不能为空"),
    RESOURCE_NOT_EXISTS("2002","资源不存在"),
    PARAM_NOT_EMPTY("2003","参数不能为空"),
    ACCESS_TOKEN_INVALID("2004","无效的AccessToken"),
    RESOURCE_EXISTS("2005","资源不可重复"),
    PARAM_LIMIT_LENGTH("2006","参数不能超出长度"),

    /*3xxx通用code*/
    MEMBER_INVALIDUPLOAD_ERROR("3001","认证失败"),
    UPDATE_ERROR("3002","更新失败"),
    SHOW_ERROR("3003","显示失败")

    ;

    private String code;

    private String message;

    ServerStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
