package com.sammidev.repository.impl;

import com.sammidev.entity.Employee;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements CrudRepository<Employee, Long> {

    private Session session;

    public EmployeeService(Session session) {
        this.session = session;
    }

    @Override
    public Employee save(Employee value) throws HibernateException {
        Long primaryKey = (Long) this.session.save(value);
        value.setId(primaryKey);
        return value;
    }

    @Override
    public Employee update(Employee value) throws HibernateException {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long value) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Boolean removeById(Long value) throws HibernateException {
        return null;
    }
}
