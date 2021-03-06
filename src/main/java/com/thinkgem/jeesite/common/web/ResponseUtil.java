package com.thinkgem.jeesite.common.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 封装消息体
 *
 * @auther lei.c
 * @Date 2017-10-10 下午13:40
 */
public class ResponseUtil {
    public static ResponseBody toFailureBody(ServerStatus serverStatus, String message){
        StringBuffer msg = new StringBuffer(serverStatus.getMessage());
        if(StringUtils.isNotEmpty(message) && StringUtils.isNotEmpty(msg.toString())){
            msg.append(":");
        }
        msg.append(message);
        return new ResponseBody(serverStatus.getCode(),msg.toString());
    }

    public static ResponseBody toSuccessBody(ServerStatus serverStatus,Object data){
        return new ResponseBody(serverStatus.getCode(),serverStatus.getMessage(),data);
    }

    public static ResponseBody toSuccessBody(Object data){
        return new ResponseBody(ServerStatus.SUCCESS.getCode(),ServerStatus.SUCCESS.getMessage(),data);
    }

    public static void writeResponse(HttpServletResponse response,ServerStatus serverStatus,Object data) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        ResponseBody responseBody = new ResponseBody(serverStatus.getCode(),serverStatus.getMessage(),data);
        response.getWriter().write(RelyJson.getObjectMapper().writeValueAsString(responseBody));
    }
}
