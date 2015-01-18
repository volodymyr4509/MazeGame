package com.game.mazeapp.dao;

import com.game.mazeapp.entity.Player;
import com.game.mazeapp.utils.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Acer on 11/24/2014.
 */
public class PlayerDaoImpl {

    public boolean save(Player player){
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;
        try{
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
            System.out.println("Player saved successfully: "+ player);
            status = true;
        }catch (Exception e){
            System.out.println("Player saving process rollback....");
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return status;
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

    public Player findPlayerByID(Long id){
        Session session = HibernateHelper.getSessionFactory().openSession();
        if(id.equals(null)){
            return null;
        }
        Player player = null;
        try {
            player = (Player)session.createQuery("FROM Player WHERE id = :playerID").setParameter("playerID",id).uniqueResult();
            System.out.println("-----findPlayerByID: Player's nickName: " + player.getNickName());
        }finally {
            session.close();
        }
        return player;
    }

}
