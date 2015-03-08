package com.game.mazeapp.manager.interfaces;

import com.game.mazeapp.entity.Player;

import java.util.Map;

/**
 * Created by Home on 08.03.2015.
 */
public interface PlayerManager {
    public boolean writePlayerToDatabase(Player player);

    public Player findPlayerByNickName(String nickName);

    public Map<String, Integer> findPlayerSpecificationsByNickName(String nickName);

    public Player authenticate(Long playerID, String playerPassword);

    public void validatePlayer(Player player);

}