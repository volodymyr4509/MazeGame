package com.game.mazeapp.dao;


import com.game.mazeapp.entity.CurrentPlayerState;
import com.game.mazeapp.utils.HibernateHelper;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by Home on 18.01.2015.
 */
public class CurrentPlayerStateDaoImpl {


    public boolean update(CurrentPlayerState currentPlayerState){
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            session.update(currentPlayerState);
            transaction.commit();
            System.out.println("currentPlayerState updated successfully: "+ currentPlayerState);
            status = true;
        }catch (Exception e){
            System.out.println("currentPlayerState updating process rollback....");
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return status;
    }
}
