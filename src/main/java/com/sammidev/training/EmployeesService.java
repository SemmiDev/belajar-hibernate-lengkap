package com.sammidev.training;

import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeesService implements CrudRepository<Employees, String> {

    private Session session;

    public EmployeesService(Session session) {
        this.session = session;
    }

    @Override
    public Employees save(Employees value) throws HibernateException {
        String primaryKey = (String) this.session.save(value);
        value.setCode(primaryKey);
        return value;
    }

    @Override
    public Employees update(Employees value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public Optional<Employees> findById(String value) {
        var employees = this.session.find(Employees.class, value);
        return employees != null ? Optional.of(employees) : Optional.empty();
    }

    @Override
    public List<Employees> findAll() {
        return this.session.createQuery("FROM com.sammidev.training.Employees", Employees.class).list();
    }

    public boolean remove(Employees employees) {
        this.session.remove(employees);
        return true;
    }

    @Override
    public Boolean removeById(String value) throws HibernateException {
        var data = findById(value);
        this.session.remove(data.get());
        return true;
    }
}