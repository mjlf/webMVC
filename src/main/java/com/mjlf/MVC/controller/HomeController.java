package com.mjlf.MVC.controller;

import com.mjlf.MVC.Entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a123 on 17/6/1.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController{

    @Autowired
    private Spitter spitter;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("message", "yes");
        return "home";
    }

    @RequestMapping("/welcome")
    public void welcome(HttpServletResponse response , Date date) throws IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        response.getWriter().write("welcome here again !  current date is "+format.format(date));
    }
}
