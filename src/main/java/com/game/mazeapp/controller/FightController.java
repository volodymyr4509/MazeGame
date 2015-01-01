package com.game.mazeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Home on 27.12.2014.
 */

@Controller
public class FightController {

    @RequestMapping("/beginfight")
    public String beginFight(){

        return "fightForm";
    }

    @RequestMapping(value = "/kick", method = RequestMethod.POST)
    public @ResponseBody String kick(@ModelAttribute(value = "kickInfo")String kick, BindingResult bindingResult){
        System.out.println("Binding result : " + bindingResult);
        System.out.println("kick : "+kick);
    return "hello kick";
    }

}
