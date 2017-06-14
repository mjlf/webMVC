package com.mjlf.MVC.controller;

import com.mjlf.MVC.Entity.Spitter;
import com.mjlf.MVC.exception.MyNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by a123 on 17/6/14.
 * 练习spring mvc 中异常处理
 */
@Controller
@RequestMapping({"/", "/home"})
public class MyExceptionController1{

    /**
     * 编写该方法为了验证抛出ExceptionHandler异常时会自动执行定义的  @ExceptionHandler(MyNotFoundException.class)
     * public String handleMyNotFoundExcetion()方法, 并返回该方法返回的内容
     * @param spitter
     * @param errors
     * @return
     */
    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception(@Valid Spitter spitter, Errors errors) {
        if (System.currentTimeMillis() % 2 == 0) {
            return "home";
        } else {
            throw new MyNotFoundException();
        }
    }


    /**
     * 验证该方法在抛出异常ExceptionHandler时会执行handleMyNotFoundExcetion()方法, 即使在当前方法定义为void
     * 在执行handleMyNotFoundExcetion()后依旧会返回handleMyNotFoundExcetion()方法的返回值
     * @param spitter
     * @param errors
     * @param response
     */
    @RequestMapping(value = "/exception1", method = RequestMethod.GET)
    public void exception1(@Valid Spitter spitter, Errors errors, HttpServletResponse response) {
        if (System.currentTimeMillis() % 2 == 0) {
            try {
                response.getWriter().write("yes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new MyNotFoundException();
        }
    }
}
