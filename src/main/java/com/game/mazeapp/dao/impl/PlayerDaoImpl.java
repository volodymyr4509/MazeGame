package com.game.mazeapp.dao.impl;

import com.game.mazeapp.dao.interfaces.PlayerDao;
import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entity.Player;
import com.game.mazeapp.utils.HibernateHelper;
import org.hibernate.Session;

/**
 * Created by Acer on 11/24/2014.
 */
public class PlayerDaoImpl extends GenericDaoImpl<Player> implements PlayerDao {


    public PlayerDaoImpl (){
        super(Player.class);
    }

    public Player findPlayerByNickName(String nickName){
        Session session = HibernateHelper.getSessionFactory().openSession();
        if(nickName.equals(null) || nickName.length()==0){
            return null;
        }
        Player player = null;
        try {
            player = (Player)session.createQuery("FROM Player WHERE nickName like :userNickName").setParameter("userNickName",nickName).uniqueResult();
            System.out.println("-----findPlayerByNickName: Player's nickName: " + nickName);
        }finally {
            session.close();
        }
        return player;
    }

    public Fight findFightByPlayerNickName(String currentPlayerNickName){
        Session session = HibernateHelper.getSessionFactory().openSession();
        if(currentPlayerNickName.equals(null) || currentPlayerNickName.length() == 0){
            return null;
        }
        Fight fight = null;
        try{
            fight = (Fight)session.createQuery("SELECT max (f) FROM Fight f INNER JOIN f.players p " +
                    "WHERE p.nickName = :nickName").setParameter("nickName", currentPlayerNickName).uniqueResult();
        }finally {
            session.close();
        }
        return fight;
    }

}
