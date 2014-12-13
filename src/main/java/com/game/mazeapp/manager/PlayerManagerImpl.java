package com.game.mazeapp.manager;

import com.game.mazeapp.dao.PlayerDaoImpl;
import com.game.mazeapp.entity.Player;

/**
 * Created by Home on 06.12.2014.
 */
public class PlayerManagerImpl {
    PlayerDaoImpl playerDao = new PlayerDaoImpl();

    public boolean writePlayerToDatabase(Player player){
        player.setHealth(100);
        return playerDao.save(player);
    }

    public Player findPlayerByNickName(String nickName){
        return playerDao.findPlayerByNickName(nickName);
    }

    public Player authenticate(Long playerID, String playerPassword){
        Player player = playerDao.findPlayerByID(playerID);
        if(player == null){
            return null;
        }
        if(player.getPassword().equals(playerPassword)){
            System.out.println("----------authenticate: Player with nickName: " + player.getNickName() +" authenticated successfully");
            return player;
        }else {
            return null;
        }
    }
}
