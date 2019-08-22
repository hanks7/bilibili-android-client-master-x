package com.hotbitmapgg.bilibili.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/**
 * Created by liu on 15/5/29.
 * 解析Gson数据格式
 */
public class UtilGson {
    public static void main(String[] args) {



    }


    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private UtilGson() {
    }


    /**
     * 转成bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T toBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    public static String toJson(Object obj) {
        try {
            if (obj == null) return null;
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(obj);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 得到json文件中的内容
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 得到json文件中的内容
     *
     * @param context
     * @param fileName
     * @return eg:UtilGson.getJson(getContext(), "评论.json", VideoCommentInfo.class)
     */
    public static <T> T getJson(Context context, String fileName, Class<T> cls) {

        String json = getJson(context, fileName);
        return toBean(json, cls);
    }


    /**
     * json字符串转成对象
     *
     * @param str
     * @param type
     * @return
     */
    public static Object fromJsonToObject(String str, Type type) {
        try {
            return gson.fromJson(str, type);
        } catch (Exception e) {
        }
        return null;
    }


    /**
     * json字符串转成对象
     *
     * @param str
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Object fromJsonToObject(String str, Class clazz) {
        try {
            return gson.fromJson(str, clazz);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 将字符串转换为 对象
     *
     * @param json
     * @param type
     * @return
     */
    public static <T> T JsonToObject(String json, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }
}
