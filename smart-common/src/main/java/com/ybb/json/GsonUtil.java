package com.ybb.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class GsonUtil {

    private static GsonUtil sInstance = null;

    private Gson gson = null;

    private  GsonUtil(){
        gson = new Gson();
    }

    public static GsonUtil get(){
        if(sInstance == null){
            sInstance = new GsonUtil();
        }
        return sInstance;
    }


    public <T> T fromJson(String srcJson, Type distObj){
        try {
            return gson.fromJson(srcJson, distObj);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> T fromJson(String srcJson, Class<T> distObj){
        try {
            return gson.fromJson(srcJson, distObj);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String toJson(Object srcObj){
        if(srcObj == null){
            return "{\"parse\":\"error!\"}";
        }
        try {
            return gson.toJson(srcObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"parse\":\"error!\"}";
    }


}
