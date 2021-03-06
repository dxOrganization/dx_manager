package com.thinkgem.jeesite.common.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.List;

/**
 * description：
 * author：WangShuai
 * time：2017年02月20 13:52:00
 * 修改时间：2017年02月20 13:52:00
 * 修改备注：
 */
public class RelyJson {

    /**
     * 将bean转化成json字符串
     * @param bean
     * @param features
     * @param propertyfilters
     * @param nameFilters
     * @param valueFilters
     * @param defaultJSON  如果bean为null的话，方法就会返回defaultJSON
     * @return
     */
    public static String extractJson(Object bean, SerializerFeature[] features,
                                     PropertyFilter[] propertyfilters, NameFilter[] nameFilters, ValueFilter[] valueFilters,
                                     String defaultJSON) {
        if(bean == null) {
            return defaultJSON;
        }

        SerializeWriter out = features != null ?
                new SerializeWriter(features) : new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        if(propertyfilters != null) {
            for(PropertyFilter filter : propertyfilters)
                serializer.getPropertyFilters().add(filter);
        }
        if(nameFilters != null) {
            for(NameFilter filter : nameFilters)
                serializer.getNameFilters().add(filter);
        }
        if(valueFilters != null) {
            for(ValueFilter filter : valueFilters)
                serializer.getValueFilters().add(filter);
        }
        serializer.write(bean);
        return out.toString();
    }
    /**
     * 将bean转化成json字符串
     * @param bean
     * @param propertyfilters
     * @param nameFilters
     * @param valueFilters
     * @param defaultJSON
     * @return
     */
    public static String extractJson(Object bean,
                                     PropertyFilter[] propertyfilters, NameFilter[] nameFilters, ValueFilter[] valueFilters,
                                     String defaultJSON) {
        if(bean == null) {
            return defaultJSON;
        }
        SerializerFeature[] features = {
                SerializerFeature.WriteNullListAsEmpty,//list字段如果为null，输出为[]，而不是null
                SerializerFeature.WriteNullStringAsEmpty,//字符类型字段如果为null，输出为""，而不是null
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteMapNullValue
        };
        SerializeWriter out = features != null ?
                new SerializeWriter(features) : new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        if(propertyfilters != null) {
            for(PropertyFilter filter : propertyfilters)
                serializer.getPropertyFilters().add(filter);
        }
        if(nameFilters != null) {
            for(NameFilter filter : nameFilters)
                serializer.getNameFilters().add(filter);
        }
        if(valueFilters != null) {
            for(ValueFilter filter : valueFilters)
                serializer.getValueFilters().add(filter);
        }
        serializer.write(bean);
        return out.toString();
    }
    /**
     * 将bean转换成json字符串
     * list字段如果为null，输出为[]，而不是null
     * 字符类型字段如果为null，输出为""，而不是null
     * @param bean
     * @return
     */
    public static String extractJson(Object bean){
        SerializerFeature[] features = {
                SerializerFeature.WriteNullListAsEmpty,//list字段如果为null，输出为[]，而不是null
                SerializerFeature.WriteNullStringAsEmpty,//字符类型字段如果为null，输出为""，而不是null
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteMapNullValue
        };
        return JSON.toJSONString(bean,features);
    }
    /**
     * 将bean转换成json字符串，如果bean中含有Date类型的字段，则按照format格式输出
     * list字段如果为null，输出为[]，而不是null
     * 字符类型字段如果为null，输出为""，而不是null
     * @param bean
     * @param dateFormat 日期格式 例如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String extractJsonDateFormat(Object bean,String dateFormat){
        SerializerFeature[] features = {
                SerializerFeature.WriteNullListAsEmpty,//list字段如果为null，输出为[]，而不是null
                SerializerFeature.WriteNullStringAsEmpty,//字符类型字段如果为null，输出为""，而不是null
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteMapNullValue,
        };
        SerializeConfig config=new SerializeConfig();
        config.put(java.sql.Timestamp.class, new SimpleDateFormatSerializer(dateFormat));
        config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
        return JSON.toJSONString(bean,config, features);
    }
    /**
     * 将bean转换成json字符串，如果bean中含有Date类型的字段，则按照yyyy-MM-dd HH:mm:ss格式转化
     * list字段如果为null，输出为[]，而不是null
     * 字符类型字段如果为null，输出为""，而不是null
     * @param bean
     * @return
     */
    public static String extractJsonDateFormat(Object bean){
        return extractJsonDateFormat(bean,"yyyy-MM-dd HH:mm:ss");
    }

    public static <T> T parseObject(String json,Class<T> clazz){

        return JSON.parseObject(json, clazz);
    }


    private static ObjectMapper objectMapper = new ObjectMapper();
    public static ObjectMapper getObjectMapper(){
        return objectMapper;
    }

    public static String objectToJson(Object object){
        try {
            return RelyJson.getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static void main(String[] args){
        Temp temp=new Temp();
        System.out.println(extractJsonDateFormat(temp));
        System.out.println(JSON.toJSONString(temp, SerializerFeature.WriteNullStringAsEmpty));
    }


}

class Temp{
    private String note;
    private List<Object> list;
    public List<Object> getList(){
        return this.list;
    }
    public String getNote(){
        return this.note;
    }
    private Date createDate;
    public void setCreateDate(Date date){
        this.createDate=date;
    }
    public Date getCreateDate(){
        return this.createDate;
    }
}
