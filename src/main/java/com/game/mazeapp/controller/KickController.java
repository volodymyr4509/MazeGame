package com.game.mazeapp.controller;

import com.game.mazeapp.entityJSON.KickParamsJSON;
import com.game.mazeapp.entityJSON.KickResponseJSON;
import com.game.mazeapp.manager.impl.KickManagerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Home on 08.03.2015.
 */
@Controller
public class KickController {

    @RequestMapping(value = "/kick", method = RequestMethod.POST)
    public @ResponseBody KickResponseJSON kick(@RequestBody KickParamsJSON kickParams){
        System.out.println("kickparams - attack : " + kickParams.getAttack() + " block : " + kickParams.getBlock());
        KickManagerImpl kickManager = new KickManagerImpl();

        KickResponseJSON kickResponse = kickManager.processKick(kickParams);
        return kickResponse;
    }
}
