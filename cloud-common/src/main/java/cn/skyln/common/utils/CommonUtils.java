package cn.skyln.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Random;

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

    public static String getFullUrl(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        if (!StringUtils.isEmpty(queryString)) {
            requestURL = requestURL + "?" + queryString;
        }
        return requestURL;
    }

    public static int getRandomNum(int maxNum) {
        if(maxNum == 1){
            return 0;
        }else {
            Random random = new Random();
            int temp = random.nextInt(maxNum);
            if (temp > 0 && temp == maxNum) {
                return temp - 1;
            } else {
                return temp;
            }
        }
    }

}
