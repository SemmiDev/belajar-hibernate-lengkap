package com.sammidev.repository.impl;

import com.sammidev.entity.Lecture;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class LectureService implements CrudRepository<Lecture, String> {

    private Session session;

    public LectureService(Session session) {
        this.session = session;
    }

    @Override
    public Lecture save(Lecture value) throws HibernateException {
        this.session.save(value);
        return value;
    }

    @Override
    public Lecture update(Lecture value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Lecture> findById(String value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Lecture> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean removeById(String value) throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
