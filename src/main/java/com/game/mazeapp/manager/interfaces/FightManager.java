package com.game.mazeapp.manager.interfaces;

import com.game.mazeapp.entity.Fight;

/**
 * Created by Home on 08.03.2015.
 */
public interface FightManager {
    public Fight createFight(String currentPlayerNickname, String opponentNickname) throws Exception;
}
