package com.mjlf.MVC.controller;

import com.mjlf.MVC.exception.MyNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by a123 on 17/6/14.
 */

@ControllerAdvice
public class ParentController {
    /**
     * 编写该方法, 当在这个Controller类的控制器中抛出了MyNotFoundException异常, 都将返回error页面
     * @return
     */
    @ExceptionHandler(MyNotFoundException.class)
    public String handleMyNotFoundExcetion() {
        return "error";
    }
}
