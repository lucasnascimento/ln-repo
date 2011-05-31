package br.com.ln.orm;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	 
    T load(ID id);
 
    List<T> listAll();
 
    List<T> listByExample(T exampleInstance);
 
    T saveOrUpdate(T entity);

    T saveOrUpdate();
 
    void delete(T entity);
    
    void delete();
}
