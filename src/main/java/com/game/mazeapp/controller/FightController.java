package com.game.mazeapp.controller;

import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entityJSON.OpponentNameJSON;
import com.game.mazeapp.manager.impl.FightManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by Home on 27.12.2014.
 */

@Controller
public class FightController {

    @RequestMapping(value = "/savefight", method = RequestMethod.POST)
    public @ResponseBody Fight createFight(@RequestBody OpponentNameJSON opponentNickname, Principal principal){
        FightManagerImpl fightManager = new FightManagerImpl();
        String currentUserNickname = principal.getName();
        System.out.println("begin create fight: opponentNickname: "+ opponentNickname + "currentPlayer: " + currentUserNickname);
        try{
            return fightManager.createFight(currentUserNickname, opponentNickname.getMonsterNickname());
        }catch (Exception e){
            //add response parameters - 500 or something like that
            e.printStackTrace();
        }
        return null;
    }



}
