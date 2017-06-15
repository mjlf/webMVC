package com.mjlf.MVC.controller.redis;

import com.mjlf.MVC.server.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by a123 on 17/6/15.
 */
@Controller
@RequestMapping({"/", "/home"})
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public void getName(HttpServletRequest request, HttpServletResponse response){
        redisService.setValue("123", "123123");
        System.out.println(redisService.getValue("123"));
    }
}
