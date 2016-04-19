package com.example.athi.assignment7domain.repository;

import java.util.Set;

/**
 * Created by Administrator on 2016/04/19.
 */

public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}
