package com.sammidev.repository.impl;

import com.sammidev.entity.Teacher;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class TeacherService implements CrudRepository<Teacher, String> {

    private Session session;

    public TeacherService(Session session) {
        this.session = session;
    }

    @Override
    public Teacher save(Teacher value) throws HibernateException {
        String primaryKey = (String) this.session.save(value);
        value.setId(primaryKey);
        return value;

    }

    @Override
    public Teacher update(Teacher value) throws HibernateException {
        return null;
    }

    @Override
    public Optional<Teacher> findById(String value) {
        return Optional.empty();
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }

    @Override
    public Boolean removeById(String value) throws HibernateException {
        return null;
    }
}
