package com.game.mazeapp.controller;

import com.game.mazeapp.entity.Player;
import com.game.mazeapp.manager.PlayerManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("playerForm") Player player, Map<String,Object> model){
        PlayerManagerImpl playerManager = new PlayerManagerImpl();
        boolean status = playerManager.writePlayerToDatabase(player);
        if (status ){
            return "registrationSuccess";
        }else
            return "registration";
    }
}
