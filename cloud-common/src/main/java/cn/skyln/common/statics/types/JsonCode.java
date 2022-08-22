package cn.skyln.common.statics.types;

/**
 * @Author: lamella
 * @Date: 2022/08/20/12:48
 * @Description:
 */
public class JsonCode {

    public final static int SUCCESS_CODE = 0;

    //用户相关错误码
    public final static int NO_USER_CODE = 200;

    public final static int NO_PERMISSION_CODE = 201;
    
    public final static int NO_LOGIN_CODE = 202;
    
    public final static int INCORRECT_USERNAME_PASSWORD_CODE = 203;

    //系统相关错误码
    public final static int SYSTEM_ERROR_CODE = 300;

    public final static int SYSTEM_NO_NACOS_INSTANCE = 301;

    //数据相关错误码
    public final static int DATA_SPECIFICATION_CODE = 400;

    public final static int NO_DATA_CODE = 401;

}
