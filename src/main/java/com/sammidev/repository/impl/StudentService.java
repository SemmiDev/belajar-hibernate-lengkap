package com.sammidev.repository.impl;

import com.sammidev.entity.Student;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class StudentService implements CrudRepository<Student, Long> {

    private Session session;

    public StudentService(Session session) {
        this.session = session;
    }

    @Override
    public Student save(Student value) throws HibernateException {
        Long id = (Long) this.session.save(value);
        value.setId(id);
        return value;
    }

    @Override
    public Student update(Student value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public Optional<Student> findById(Long value) {
        var student = this.session.find(Student.class, value);
        return student != null ? Optional.of(student) : Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Student student) {
        this.session.remove(student);
        return true;
    }

    @Override
    public Boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
