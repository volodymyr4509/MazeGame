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

}
