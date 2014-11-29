package com.game.mazeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Home on 29.11.2014.
 */
@Controller
public class MazeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getdata() {

        ModelAndView model = new ModelAndView("maze");

        return model;

    }

}