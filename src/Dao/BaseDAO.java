// BaseDAO.java
package Dao;

import java.util.List;

public abstract class BaseDAO<T> {
    public abstract void insert(T entity);
    public abstract List<T> findAll();
    public abstract void update(T entity);
    public abstract void delete(String id);
}