
package com.gws.controllers;

import com.gws.enums.CodeStatus;
import com.gws.enums.SystemCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * api请求基类
 */

@ResponseBody
public class BaseController {

    @ExceptionHandler(Exception.class)
    public JsonResult handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        return response(SystemCode.HANDLE_EXCEPTION, null);
    }

    protected JsonResult success(Object data) {
        return new JsonResult(SystemCode.SUCCESS, data);
    }

    protected JsonResult error(CodeStatus codeStatus) {
        return new JsonResult(codeStatus, null);
    }

    protected JsonResult response(CodeStatus codeStatus, Object data) {
        return new JsonResult(codeStatus, data);
    }


}
