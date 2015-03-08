package com.game.mazeapp.dao.interfaces;

/**
 * Created by Home on 08.03.2015.
 */
public interface GenericDao<T> {

    public boolean save(T item);

    public boolean update(T item);

    public T getByID(Long objectId);

    public boolean delete(T item);

}
