package com.game.mazeapp.controller;

import com.game.mazeapp.manager.FightManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Home on 27.12.2014.
 */

@Controller
public class FightController {

    @RequestMapping(value = "/createNewFight", method = RequestMethod.POST)
    public @ResponseBody String createFight(@RequestParam String nicknames){
        System.out.println("begin create fight");
        //split string nicknames by regex " "
        String [] nicknamesArray = nicknames.split(" ", 10);
        FightManagerImpl fightManager = new FightManagerImpl();
        try{
            fightManager.createFight(nicknamesArray);
            return "Saved successfully";
        }catch (Exception e){
            //add response parameters - 500 or something like this
            return e.toString();
        }
    }

    @RequestMapping(value = "/kick", method = RequestMethod.POST)
    public @ResponseBody String kick(@ModelAttribute(value = "kickInfo")String kickInfo, BindingResult bindingResult){
        System.out.println("Binding result : " + bindingResult);
        System.out.println("kick : "+kickInfo);
    return "hello kick";
    }

}
