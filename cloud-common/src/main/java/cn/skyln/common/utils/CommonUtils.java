package cn.skyln.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @Author: lamella
 * @Date: 2022/08/20/16:02
 * @Description:
 */
public class CommonUtils {

    public static String MD5Password(String oldStr) {
        try {
            java.security.MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(oldStr.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFullUrl(HttpServletRequest request){
        String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        if(!StringUtils.isEmpty(queryString)){
            requestURL = requestURL + "?" + queryString;
        }
        return requestURL;
    }

}
