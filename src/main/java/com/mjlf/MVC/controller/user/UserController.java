package com.mjlf.MVC.controller.user;

import com.mjlf.MVC.Entity.User;
import com.mjlf.MVC.dao.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by a123 on 17/6/15.
 */
@Controller
@RequestMapping({"/", "/home"})
public class UserController {

    @Autowired
    private UserServer userServer;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void getName(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        User user = userServer.findName(name);
        System.out.println(user);
        try {
            response.getWriter().write(user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
