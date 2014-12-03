package com.game.mazeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Home on 29.11.2014.
 */
@Controller
@RequestMapping(value = "/maze")
public class MazeController {

    @RequestMapping(method = RequestMethod.GET)
    public String getdata() {

        //      ModelAndView model = new ModelAndView("maze");

        return "maze";


    }

}