package cn.skyln.common.utils;

import cn.hutool.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lamella
 * @Date: 2022/08/20/12:37
 * @Description:
 */
public class JsonReturn {

    public static String returnJson(int code) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        return new JSONObject(map).toString();
    }

    public static String returnJson(int code, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        return new JSONObject(map).toString();
    }

    public static String returnJson(int code, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("dataBody", data);
        return new JSONObject(map).toString();
    }

    public static String returnJson(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("dataBody", data);
        return new JSONObject(map).toString();
    }
}
