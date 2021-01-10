package com.sammidev.repository;

import org.hibernate.HibernateException;

import java.util.List;
import java.util.Optional;

public interface StudentRepository<T, ID> {

    T save(T value) throws HibernateException;
    T update(T value) throws HibernateException;
    Optional<T> findById(ID value);
    List<T> findAll();
    Boolean removeById(ID value) throws HibernateException;
}