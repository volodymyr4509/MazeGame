package com.game.mazeapp.manager;

import com.game.mazeapp.dao.PlayerDaoImpl;
import com.game.mazeapp.entity.CurrentPlayerState;
import com.game.mazeapp.entity.Player;
import com.game.mazeapp.entity.PlayerDetails;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Home on 06.12.2014.
 */
public class PlayerManagerImpl {
    PlayerDaoImpl playerDao = new PlayerDaoImpl();

    public boolean writePlayerToDatabase(Player player){
        //add playerDetails and currentPlayerState before saving new player
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextBeans.xml");
        PlayerDetails playerDetails = (PlayerDetails) applicationContext.getBean("playerDetails");
        CurrentPlayerState currentPlayerState = (CurrentPlayerState) applicationContext.getBean("currentPlayerState");
        currentPlayerState.setCurrentPlayerHealth(playerDetails.getHealth());
        currentPlayerState.setCurrentPlayerMuscle(playerDetails.getMuscle());
        player.setPlayerDetails(playerDetails);
        player.setCurrentPlayerState(currentPlayerState);
        return playerDao.save(player);
    }

    public Player findPlayerByNickName(String nickName){
        return playerDao.findPlayerByNickName(nickName);
    }

    public Map<String, Integer> findPlayerSpecificationsByNickName(String nickName){
        Map<String, Integer> playerSpecificationsMap = new LinkedHashMap<String, Integer>();
        Player player = findPlayerByNickName(nickName);
        PlayerDetails playerDetails = player.getPlayerDetails();
        playerSpecificationsMap.put("health", playerDetails.getHealth());
        playerSpecificationsMap.put("muscle", playerDetails.getMuscle());
        return playerSpecificationsMap;
    }

    public Player authenticate(Long playerID, String playerPassword){
        Player player = playerDao.findPlayerByID(playerID);
        if(player == null){
            return null;
        }
        if(player.getPassword().equals(playerPassword)){
            System.out.println("Authenticate player: " + player);
            return player;
        }else {
            return null;
        }
    }
}
