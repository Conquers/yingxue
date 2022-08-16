package com.cqupt.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 前后端分离
 * @author kioo
 */
@ControllerAdvice //给controller增加一些附加操作
public class GlobalExceptionHandler {

    /**
     * 自定义方法
     * 希望这个方法可以处理所有controller异常
     */
    @ExceptionHandler
    @ResponseBody
    public Map<String,String> exception(Exception exception){
        Map<String,String> map = new HashMap<>();
        map.put("msg",exception.getMessage());
        return map;
    }
}
