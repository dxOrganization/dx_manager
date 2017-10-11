package com.thinkgem.jeesite.common.web;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 重写输出消息处理器
 *
 * @auther lei.c
 * @Date 2017-10-10 下午13:39
 */
public class DefaultMessageConverter extends MappingJackson2HttpMessageConverter {

    /**
     * 重写输出消息处理器，统一响应体结构
     * @param object
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if( !(object instanceof ResponseBody) ){
            object = ResponseUtil.toSuccessBody(object);
        }
        super.writeInternal(object, outputMessage);
    }
}
