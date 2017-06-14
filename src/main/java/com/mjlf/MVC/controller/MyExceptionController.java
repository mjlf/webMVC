package com.mjlf.MVC.controller;

import com.mjlf.MVC.exception.MyNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by a123 on 17/6/14.
 * 练习spring mvc 中异常处理
 */
@Controller
@RequestMapping({"/", "/home"})
public class MyExceptionController{

    /**
     * 该方法是在抛出MyNotFoundException时将返回异常对应的错误码
     * 因为在MyNotFoundException类定义的时候有
     * @ResponseStatus(value = HttpStatus.NOT_FOUND,
     *   reason = "don't have this information")
     *   所以在此处并不是返回错误码500, 而是返回404
     * @param model
     * @return
     */
    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public String testException(Model model){

        if(true){
            throw new MyNotFoundException();
        }
        return "home";
    }
}
