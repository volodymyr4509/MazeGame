package com.game.mazeapp.dao.impl;


import com.game.mazeapp.dao.interfaces.CurrentPlayerStateDao;
import com.game.mazeapp.entity.CurrentPlayerState;


/**
 * Created by Home on 18.01.2015.
 */
public class CurrentPlayerStateDaoImpl extends GenericDaoImpl<CurrentPlayerState> implements CurrentPlayerStateDao {

    public CurrentPlayerStateDaoImpl (){
        super(CurrentPlayerState.class);
    }


}
