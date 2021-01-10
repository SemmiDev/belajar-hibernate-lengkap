package com.sammidev.repository.impl;

import com.sammidev.entity.CustomerID;
import com.sammidev.entity.Customerr;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CustomerService implements CrudRepository<Customerr, CustomerID> {

    private Session session;

    public CustomerService(Session session) {
        this.session = session;
    }

    @Override
    public Customerr save(Customerr value) throws HibernateException {
        CustomerID primaryKey = (CustomerID) this.session.save(value);
        value.setCustomerID(primaryKey);
        return value;
    }

    @Override
    public Customerr update(Customerr value) throws HibernateException {
        return null;
    }

    @Override
    public Optional<Customerr> findById(CustomerID value) {
        var customer = this.session.find(Customerr.class, value);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    @Override
    public List<Customerr> findAll() {
        return null;
    }

    @Override
    public Boolean removeById(CustomerID value) throws HibernateException {
        return null;
    }
}
