package com.sammidev.repository.impl;

import com.sammidev.entity.Product;
import com.sammidev.entity.ProductID;
import com.sammidev.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ProductService implements CrudRepository<Product, ProductID> {

    private Session session;

    public ProductService(Session session) {
        this.session = session;
    }

    @Override
    public Product save(Product value) throws HibernateException {
        var primaryKey = (ProductID) this.session.save(value);
        value.setId(primaryKey.getId());
        value.setCode(primaryKey.getCode());
        return value;
    }

    @Override
    public Product update(Product value) throws HibernateException {
        return null;
    }

    @Override
    public Optional<Product> findById(ProductID value) {
        var product = this.session.find(Product.class, value);
        return product != null ? Optional.of(product) : Optional.empty();

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Boolean removeById(ProductID value) throws HibernateException {
        return null;
    }
}
