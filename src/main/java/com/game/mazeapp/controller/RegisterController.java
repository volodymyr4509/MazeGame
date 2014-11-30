package com.game.mazeapp.controller;

import com.game.mazeapp.entity.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Home on 30.11.2014.
 */

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewRegistration(Map<String,Object> model){
        Player playerForm = new Player();
        model.put("playerForm", playerForm);
        List<String> sexList = new ArrayList<String>();
        sexList.add("Man");
        sexList.add("Woman");
        model.put("sexList",sexList);
        return "Registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("playerForm") Player player, Map<String,Object> model){
        System.out.println("playerName" + player.getFirstName());
        System.out.println("pass" + player.getEmail());
        return "RegistrationSuccess";
    }
}
