package com.jnshu.tools;



import java.util.HashMap;
import java.util.Map;

public class Msg {

    //状态码 100表示状态成功 200表示状态异常
    private int code;

    //返回的提示信息
    private String msg;

    //返回的业务数据，封装到hashmap中

    private Map<String,Object> ext= new HashMap<String, Object>();


    //写个快捷的提示成功和失败的方法
    public static Msg success(){
        Msg result=new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }
    public static Msg fail(){
        Msg result=new Msg();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }

    public Msg add(String key, Object value){
        this.getExt().put(key, value);
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> extend) {
        this.ext = extend;
    }






}