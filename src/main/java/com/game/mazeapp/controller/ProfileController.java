package com.game.mazeapp.controller;

import com.game.mazeapp.manager.PlayerManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Home on 13.12.2014.
 */
@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String showEmptyProfile() {

        //      ModelAndView model = new ModelAndView("maze");

    return "profile";
    }

    @RequestMapping(value = "/{playerNickName}", method = RequestMethod.GET)
    public String showPlayerProfile(@PathVariable(value = "playerNickName") String playerNickName) {
        PlayerManagerImpl playerManager = new PlayerManagerImpl();
        Map<String, Integer> playerSpecificationsMap = playerManager.findPlayerSpecificationsByNickName(playerNickName);

        ModelAndView model = new ModelAndView();
        model.addAllObjects(playerSpecificationsMap);

        return "profile";
    }
}
