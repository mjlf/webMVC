package com.mjlf.MVC.controller;

import com.mjlf.MVC.exception.MyNotFoundException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a123 on 17/6/14.
 */

@ControllerAdvice
public class AppWideExceprionHandler {
    /**
     * 编写该方法, 当在这个Controller类的控制器中抛出了MyNotFoundException异常, 都将返回error页面
     * @return
     */
    @ExceptionHandler(MyNotFoundException.class)
    public String handleMyNotFoundExcetion() {
        return "error";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }
}
