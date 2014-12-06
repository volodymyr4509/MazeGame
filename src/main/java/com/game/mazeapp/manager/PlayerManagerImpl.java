package com.game.mazeapp.manager;

import com.game.mazeapp.dao.PlayerDaoImpl;
import com.game.mazeapp.entity.Player;

/**
 * Created by Home on 06.12.2014.
 */
public class PlayerManagerImpl {

    public boolean writePlayerToDatabase(Player player){
        PlayerDaoImpl playerDao = new PlayerDaoImpl();
        player.setHealth(100);
        return playerDao.save(player);
    }
}
