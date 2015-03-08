package com.game.mazeapp.manager.impl;

import com.game.mazeapp.dao.impl.PlayerDaoImpl;
import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entityJSON.KickParamsJSON;
import com.game.mazeapp.entityJSON.KickResponseJSON;
import com.game.mazeapp.manager.interfaces.KickManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Home on 08.03.2015.
 */
public class KickManagerImpl implements KickManager{

    PlayerDaoImpl playerDao = new PlayerDaoImpl();
    public KickResponseJSON processKick(KickParamsJSON kickParams){
        //find actual player
        //find current enemy
        //calculate damages
        //return two players current states
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String currentUserNickName = currentUser.getUsername(); //get logged in username
        //TODO in kick can be only two players
        Fight fight = playerDao.findFightByPlayerNickName(currentUserNickName);

        KickResponseJSON kickResponse = new KickResponseJSON(fight);
        return kickResponse;
    }



}
