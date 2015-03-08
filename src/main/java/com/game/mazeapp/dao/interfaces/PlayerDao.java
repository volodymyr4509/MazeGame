package com.game.mazeapp.dao.interfaces;

import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entity.Player;

/**
 * Created by Home on 08.03.2015.
 */
public interface PlayerDao {

    public Player findPlayerByNickName(String nickName);
    public Fight findFightByPlayerNickName(String currentPlayerNickName);

}