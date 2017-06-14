package com.mjlf.MVC.controller;

import com.mjlf.MVC.Entity.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
