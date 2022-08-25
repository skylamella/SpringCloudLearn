package cn.skyln.common.statics;

/**
 * @Author: lamella
 * @Date: 2022/08/20/12:48
 * @Description:
 */
public class JsonMessage {

    public final static String SEARCH_SUCCESS_MESSAGE = "数据查询成功！";

    public final static String OPERATE_SUCCESS_MESSAGE = "操作成功！数据更新可能延迟，如刷新后未显示变更，请耐心等待。";

    //用户相关错误提示信息
    public final static String NO_USER_MESSAGE = "无法找到该用户，请联系系统管理员。";

    public final static String NO_PERMISSION_MESSAGE = "您无权访问该系统资源，请联系系统管理员。";

    public final static String NO_LOGIN_MESSAGE = "该系统资源需登录后再尝试访问，当前未登录，请先登录。";

    public final static String INCORRECT_USERNAME_PASSWORD_MESSAGE = "账号或密码错误，请重试，或联系系统管理员。";

    //系统相关错误码
    public final static String SYSTEM_ERROR_MESSAGE = "系统错误，请稍后重试，或联系系统管理员。";

    public final static String SYSTEM_NO_NACOS_INSTANCE = "没有NACOS服务，请稍后重试，或联系系统管理员。";

    //数据相关错误码
    public final static String DATA_SPECIFICATION_MESSAGE = "数据不符合规范，请检查后重新输入。";

    public final static String ERROR_DATA_MESSAGE = "错误数据：";

    public final static String NO_DATA_MESSAGE = "数据不存在，请检查后重新输入。";

    //流控相关错误码
    public final static String FLOW_EXCEPTION_MESSAGE = "已触发限流，请稍后再次尝试。";

    public final static String DEGRADE_EXCEPTION_MESSAGE = "已触发降级，请稍后再次尝试。";

    public final static String PARAM_FLOW_EXCEPTION_MESSAGE = "热点参数异常，已触发流量控制，请稍后再次尝试。";

    public final static String SYSTEM_BLOCK_EXCEPTION_MESSAGE = "系统规则异常，已触发流量控制，请稍后再次尝试。";

    public final static String AUTHORITY_EXCEPTION_MESSAGE = "认证异常，已触发流量控制，请稍后再次尝试。";
}
