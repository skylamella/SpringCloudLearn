package cn.skyln.order.exception;

import cn.skyln.common.statics.JsonCode;
import cn.skyln.common.statics.JsonMessage;
import cn.skyln.common.utils.JsonReturn;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lamella
 * @Date: 2022/08/25/22:37
 * @Description:
 */
@Component
public class SkylnBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        int code = 0;
        String msg = null;
        if (e instanceof FlowException) {
            code = JsonCode.FLOW_EXCEPTION_CODE;
            msg = JsonMessage.FLOW_EXCEPTION_MESSAGE;
        } else if (e instanceof DegradeException) {
            code = JsonCode.DEGRADE_EXCEPTION_CODE;
            msg = JsonMessage.DEGRADE_EXCEPTION_MESSAGE;
        } else if (e instanceof ParamFlowException) {
            code = JsonCode.PARAM_FLOW_EXCEPTION_CODE;
            msg = JsonMessage.PARAM_FLOW_EXCEPTION_MESSAGE;
        } else if (e instanceof SystemBlockException) {
            code = JsonCode.SYSTEM_BLOCK_EXCEPTION_CODE;
            msg = JsonMessage.SYSTEM_BLOCK_EXCEPTION_MESSAGE;
        } else if (e instanceof AuthorityException) {
            code = JsonCode.AUTHORITY_EXCEPTION_CODE;
            msg = JsonMessage.AUTHORITY_EXCEPTION_MESSAGE;
        }
        httpServletResponse.setStatus(200);
        httpServletResponse.setHeader("content-Type", "application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JsonReturn.returnJson(code, msg));
    }
}
