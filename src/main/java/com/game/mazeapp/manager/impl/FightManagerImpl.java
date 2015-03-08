package com.game.mazeapp.manager.impl;

import com.game.mazeapp.dao.impl.CurrentPlayerStateDaoImpl;
import com.game.mazeapp.dao.impl.FightDaoImpl;
import com.game.mazeapp.dao.impl.PlayerDaoImpl;
import com.game.mazeapp.entity.CurrentPlayerState;
import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entity.Player;
import com.game.mazeapp.manager.interfaces.FightManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Acer on 1/11/2015.
 */
public class FightManagerImpl implements FightManager{

    public Fight createFight(String currentPlayerNickname, String opponentNickname) throws Exception{
        PlayerDaoImpl playerDao = new PlayerDaoImpl();
        FightDaoImpl fightDao = new FightDaoImpl();
        CurrentPlayerStateDaoImpl currentPlayerStateDao = new CurrentPlayerStateDaoImpl();
        Set<Player> playerSet = new LinkedHashSet<>();

        Player currentPlayer = playerDao.findPlayerByNickName(currentPlayerNickname);
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextBeans.xml");
        //create monster unique nickname;
        Player opponentPlayer = (Player) applicationContext.getBean(opponentNickname);
        opponentPlayer.setNickName(opponentNickname + System.currentTimeMillis());

        System.out.println("opponentPlayer: " + opponentPlayer);

        if(currentPlayer != null && opponentPlayer != null){
            playerSet.add(currentPlayer);
            playerSet.add(opponentPlayer);
        }else throw new IllegalArgumentException("Unable to find players with nickName: " + currentPlayerNickname + " - " + opponentNickname);
        CurrentPlayerState currentPlayerState = currentPlayer.getCurrentPlayerState();
        currentPlayerState.setInFight(true);
        currentPlayerStateDao.update(currentPlayerState);
        Fight fight = new Fight();
        fight.setPlayers(playerSet);
        boolean saved = fightDao.save(fight);
        if(!saved){
            throw new Exception("For some reason fight wasn't saved correctly");
        }
        return fight;
    }

}
