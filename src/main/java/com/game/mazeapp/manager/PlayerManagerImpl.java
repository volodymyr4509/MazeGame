package com.game.mazeapp.manager;

import com.game.mazeapp.dao.PlayerDaoImpl;
import com.game.mazeapp.entity.Player;
import com.game.mazeapp.entity.PlayerSpecifications;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Home on 06.12.2014.
 */
public class PlayerManagerImpl {
    PlayerDaoImpl playerDao = new PlayerDaoImpl();

    public boolean writePlayerToDatabase(Player player){
        return playerDao.save(player);
    }

    public Player findPlayerByNickName(String nickName){
        return playerDao.findPlayerByNickName(nickName);
    }

    public Map<String, Integer> findPlayerSpecificationsByNickName(String nickName){
        Map<String, Integer> playerSpecificationsMap = new LinkedHashMap<String, Integer>();
        Player player = findPlayerByNickName(nickName);
        PlayerSpecifications playerSpecifications = player.getPlayerSpecification();
        playerSpecificationsMap.put("health", playerSpecifications.getHealth());
        playerSpecificationsMap.put("muscle", playerSpecifications.getMuscle());
        return playerSpecificationsMap;
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
