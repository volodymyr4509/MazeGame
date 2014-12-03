package com.game.mazeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Acer on 12/2/2014.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String,Object> model){
        return "home";
    }
}
