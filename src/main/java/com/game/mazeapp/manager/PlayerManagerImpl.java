package com.game.mazeapp.manager;

import com.game.mazeapp.dao.PlayerDaoImpl;
import com.game.mazeapp.entity.CurrentPlayerState;
import com.game.mazeapp.entity.Player;
import com.game.mazeapp.entity.PlayerDetails;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Home on 06.12.2014.
 */
public class PlayerManagerImpl {
    PlayerDaoImpl playerDao = new PlayerDaoImpl();

    private static final String NICKNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";



    public boolean writePlayerToDatabase(Player player){
        //validate player
        validatePlayer(player);
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

    public void validatePlayer(Player player){

        boolean nicknamePassed = player.getNickName().matches(NICKNAME_PATTERN);
        if(!nicknamePassed){
            System.out.println(player.getNickName() + " doesn't match nickname regex: " + NICKNAME_PATTERN);
            throw new IllegalArgumentException(player.getNickName() + " doesn't match nickname regex: " + NICKNAME_PATTERN);
        }
        boolean passwordPassed = player.getPassword().matches(PASSWORD_PATTERN);
        if(!passwordPassed){
            System.out.println("Player Password doesn't match password regex: " + PASSWORD_PATTERN);
            throw new IllegalArgumentException("Player Password doesn't match password regex: " + PASSWORD_PATTERN);
        }
        boolean emailPassed = player.getEmail().matches(EMAIL_PATTERN);
        if(!emailPassed){
            System.out.println(player.getEmail() + " doesn't match email regex: " + EMAIL_PATTERN);
            throw new IllegalArgumentException(player.getEmail() + " doesn't match email regex: " + EMAIL_PATTERN);
        }

        //check player's nickname uniqueness
        Player existingPlayer = findPlayerByNickName(player.getNickName());
        if(existingPlayer!=null){
            System.out.println("Player with nickname " + player.getNickName() + " already exists");
            throw new IllegalArgumentException("Player with nickname " + player.getNickName() + " already exists");
        }
    }
}
