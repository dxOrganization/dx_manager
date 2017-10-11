package com.thinkgem.jeesite.common.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息体实体类
 *
 * @auther lei.c
 * @Date 2017-10-10 下午13:42
 */
public class ResponseBody {

    private String code;

    private String message;

    private Object data;


    public ResponseBody() {
    }

    public ResponseBody(Object data) {
    }

    public ResponseBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseBody(String code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Map toMap(){
        Map map = new HashMap();
        map.put("code",this.getCode());
        map.put("message",this.getMessage());
        map.put("data",this.getData());

        return map;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
