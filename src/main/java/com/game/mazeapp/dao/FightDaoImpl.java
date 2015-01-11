package com.game.mazeapp.dao;

import com.game.mazeapp.entity.Fight;
import com.game.mazeapp.entity.Player;
import com.game.mazeapp.utils.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Acer on 1/11/2015.
 */
public class FightDaoImpl {

    public boolean save(Fight fight){
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;
        try {
            transaction = session.beginTransaction();
            session.save(fight);
            transaction.commit();
            status = true;
            System.out.println("Fight was saved");
        }catch (Exception e){
            System.out.println("Fight saving process rollback....");
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return status;
    }
}
