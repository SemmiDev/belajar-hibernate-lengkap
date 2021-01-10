package com.sammidev.repository.impl;

import com.sammidev.entity.Person;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class PersonService implements CrudRepository<Person, Long> {

    private Session session;

    public PersonService(Session session) {
        this.session = session;
    }

    @Override
    public Person save(Person value) throws HibernateException {
        this.session.save(value);
        return value;
    }

    @Override
    public Person update(Person value) throws HibernateException {
        return null;
    }

    @Override
    public Optional<Person> findById(Long value) {
        return Optional.empty();
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Boolean removeById(Long value) throws HibernateException {
        return null;
    }
}
