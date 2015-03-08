package com.game.mazeapp.dao.impl;

import com.game.mazeapp.dao.interfaces.GenericDao;
import com.game.mazeapp.utils.HibernateHelper;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

/**
 * Created by Home on 08.03.2015.
 */
public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> objectClass;

    public GenericDaoImpl(Class<T> objectClass){
        this.objectClass = objectClass;
    }

    public boolean save(T item) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;

        try {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
            status = true;
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return status;
    }

    public boolean update(T item) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;

        try {
            transaction = session.beginTransaction();
            session.update(item);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return status;
    }

    public T getByID(Long id) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        T obj = null;

        try {
            transaction = session.beginTransaction();
            obj = (T) session.get(objectClass, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return obj;
    }

    public boolean delete(T item) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;

        try {
            transaction = session.beginTransaction();
            session.delete(item);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return status;
    }
}
