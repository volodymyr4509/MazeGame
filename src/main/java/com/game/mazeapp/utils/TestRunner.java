package com.game.mazeapp.utils;

import com.game.mazeapp.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Acer on 11/24/2014.
 */
public class TestRunner {
    public static void main(String[]args){
        Player player = new Player();
//        PlayerDetails details = (PlayerDetails) context.getBean("playerDetails");
        PlayerDetails details = player.getPlayerDetails();
        System.out.println(details.getHealth());

//        HibernateHelper hibernateHelper = new HibernateHelper();
//        Player player1 = new Player();
//        Player player2 = new Player();
//        player1.setNickName("nick1");
//        player1.setPassword("pass");
//        player1.setEmail("email1");
//        player2.setNickName("nick2");
//        player2.setPassword("pass");
//        player2.setEmail("email2");
//        Set<Player> players = new HashSet<Player>();
//        players.add(player1);
//        players.add(player2);
//
//        Fight fight = new Fight();
//        fight.setPlayers(players);
//
//        Fight fight1 = new Fight();
//        fight1.setPlayers(players);
//
//        Session session =  hibernateHelper.getSessionFactory().openSession();
//        Transaction transaction = null;
//        try{
//            transaction = session.beginTransaction();
//            session.save(player1);
//            session.save(player2);
//            session.save(fight);
//            session.save(fight1);
//            transaction.commit();
//        }catch (Exception e){
//            System.out.println(e);
//            e.printStackTrace();
//            transaction.rollback();
//        }
//        hibernateHelper.shutdown();

    }
}
