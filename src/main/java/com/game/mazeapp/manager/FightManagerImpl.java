package com.game.mazeapp.manager;

import com.game.mazeapp.dao.CurrentPlayerStateDaoImpl;
import com.game.mazeapp.dao.FightDaoImpl;
import com.game.mazeapp.dao.PlayerDaoImpl;
import com.game.mazeapp.entity.CurrentPlayerState;
import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entity.Player;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Acer on 1/11/2015.
 */
public class FightManagerImpl {

    public void createFight(String [] nicknames) throws Exception{
        PlayerDaoImpl playerDao = new PlayerDaoImpl();
        FightDaoImpl fightDao = new FightDaoImpl();
        Player attacker = null;
        Player defender = null;
        //find players in db
        if(nicknames.length == 2){
            attacker = playerDao.findPlayerByNickName(nicknames[0]);
            defender = playerDao.findPlayerByNickName(nicknames[1]);
            System.out.println("attaker: " + attacker+ " defender: " + defender);
        }else throw new IllegalArgumentException("Wrong players' nicknames format or nicknames are too short. Nicknames: " + Arrays.toString(nicknames));
        if(attacker != null && defender != null){
            //create fight object
            Fight fight = new Fight();
            Set<Player> playerSet = new LinkedHashSet<>();
            playerSet.add(attacker);
            playerSet.add(defender);
            fight.setPlayers(playerSet);
            //update players' states to "inFight"
            CurrentPlayerState attackerState = attacker.getCurrentPlayerState();
            CurrentPlayerState defenderState = defender.getCurrentPlayerState();
            CurrentPlayerStateDaoImpl currentPlayerStateDao = new CurrentPlayerStateDaoImpl();
            currentPlayerStateDao.update(attackerState);
            currentPlayerStateDao.update(defenderState);
            defender.getCurrentPlayerState().setInFight(true);
            boolean saved = fightDao.save(fight);
            if(!saved){
                throw new Exception("Fight wasn't saved correctly");
            }
        }else throw new IllegalArgumentException("There isn't player(s) ---> " + attacker==null?"attackerNickname:"+nicknames[0]:"" + defender==null?"defenderNickname:"+nicknames[1]:"");

    }
}
