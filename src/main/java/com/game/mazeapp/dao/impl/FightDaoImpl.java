package com.game.mazeapp.dao.impl;

import com.game.mazeapp.dao.interfaces.FightDao;
import com.game.mazeapp.entity.Fight;

/**
 * Created by Acer on 1/11/2015.
 */
public class FightDaoImpl extends GenericDaoImpl<Fight> implements FightDao {

    public FightDaoImpl(){
        super(Fight.class);
    }

}
