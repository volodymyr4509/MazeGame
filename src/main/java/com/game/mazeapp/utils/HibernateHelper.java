package com.game.mazeapp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by Acer on 11/20/2014.
 */

//As I decided all hibernate we will manage all entity/session/transaction by hands. At least at the beginning.
public class HibernateHelper {
    private static SessionFactory sessionFactory = null;
    private static void buildSessionFactory(){
        try{
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch (Exception e) {
            System.out.println("Initial session factory creation failed ");
            System.out.println(e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
