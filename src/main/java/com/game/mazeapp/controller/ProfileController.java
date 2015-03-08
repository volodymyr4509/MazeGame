package com.game.mazeapp.controller;

import com.game.mazeapp.entity.Player;
import com.game.mazeapp.manager.impl.PlayerManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public Player showPlayerProfile(@PathVariable(value = "playerNickName") String playerNickName) {
        System.out.println("profileController, playerNickname: " + playerNickName);
        PlayerManagerImpl playerManager = new PlayerManagerImpl();
        Player player = playerManager.findPlayerByNickName(playerNickName);
        System.out.println("currentplayer: " + player);
        //serialize player and read by js on profile page.

        return player;
    }
}
