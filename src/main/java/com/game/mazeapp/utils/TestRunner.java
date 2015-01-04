package com.game.mazeapp.utils;

import com.game.mazeapp.entity.Player;
import com.game.mazeapp.entity.PlayerDetails;
import com.game.mazeapp.entity.PlayerDetailsVersion;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Acer on 11/24/2014.
 */
public class TestRunner {
    public static void main(String[]args){
        HibernateHelper hibernateHelper = new HibernateHelper();
//        Player player1 = new Player();
//        player1.setEmail("123456");
//        player1.setNickName("nickname26");
//        player1.setPassword("daslkklagsd");
//
        PlayerDetails playerDetails1 = new PlayerDetails();
        playerDetails1.setHealth(99);
//        player1.setPlayerDetails(playerDetails1);
//        playerDetails1.setPlayer(player1);

        PlayerDetailsVersion playerDetailsVersion = new PlayerDetailsVersion();
        playerDetailsVersion.setPlayerDetails(playerDetails1);
        Session session =  hibernateHelper.getSessionFactory().openSession();

        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(playerDetailsVersion);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            transaction.rollback();
        }
        hibernateHelper.shutdown();

    }
}
