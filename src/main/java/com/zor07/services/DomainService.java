package com.zor07.services;


public interface DomainService<T> {
    Iterable<T> listAll();

    T getById(Integer id);

    T save(T obj);

    void delete(Integer id);

}
