package com.gyx.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author gyx
 * @date 2018-06-04 10:57
 * @since 1.0.0
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
