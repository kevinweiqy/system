package com.entor.dao;

public interface BaseDao<K,T> {
    public void save(T entity);
    
    public void delete(T entity);
    
    public void update(T entity);
    
    public T get(Class cla,K id);
    
}
