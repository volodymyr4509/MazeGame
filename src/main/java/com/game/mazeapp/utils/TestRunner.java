package com.game.mazeapp.utils;

import com.game.mazeapp.entity.Player;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Acer on 11/24/2014.
 */
public class TestRunner {
    public static void main(String[]args){
        HibernateHelper hibernateHelper = new HibernateHelper();
        Player player1 = new Player();
        player1.setEmail("slsadf");
        player1.setFirstName("firstnAME");
        player1.setHealth(100);
        player1.setLastName("sdafasfasfasf");
        player1.setNickName("nickname");
        player1.setPassword("daslkklagsd");
        Session session =  hibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(player1);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            transaction.rollback();
        }
        hibernateHelper.shutdown();

    }
}
