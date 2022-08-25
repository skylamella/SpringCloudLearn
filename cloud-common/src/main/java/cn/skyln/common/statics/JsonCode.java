package cn.skyln.common.statics;

/**
 * @Author: lamella
 * @Date: 2022/08/20/12:48
 * @Description:
 */
public class JsonCode {

    public final static int SUCCESS_CODE = 0;

    //用户相关错误码
    public final static int NO_USER_CODE = -100;

    public final static int NO_PERMISSION_CODE = -101;
    
    public final static int NO_LOGIN_CODE = -102;
    
    public final static int INCORRECT_USERNAME_PASSWORD_CODE = -103;

    //系统相关错误码
    public final static int SYSTEM_ERROR_CODE = -200;

    public final static int SYSTEM_NO_NACOS_INSTANCE = -201;

    //数据相关错误码
    public final static int DATA_SPECIFICATION_CODE = -300;

    public final static int NO_DATA_CODE = -301;

    //流控相关错误码
    public final static int FLOW_EXCEPTION_CODE = -400;

    public final static int DEGRADE_EXCEPTION_CODE = -401;

    public final static int PARAM_FLOW_EXCEPTION_CODE = -402;

    public final static int SYSTEM_BLOCK_EXCEPTION_CODE = -403;

    public final static int AUTHORITY_EXCEPTION_CODE = -404;

}
