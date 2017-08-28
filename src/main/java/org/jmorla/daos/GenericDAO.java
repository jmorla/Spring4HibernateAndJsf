package org.jmorla.daos;

import java.util.List;

/**
 * Created by jmorla on 27/08/17.
 */
public interface GenericDAO <T,ID> {

    void save(T t);

    void update(T t);

    void delete(T t);

    T findById(ID id);

    List<T> findAll();
}
