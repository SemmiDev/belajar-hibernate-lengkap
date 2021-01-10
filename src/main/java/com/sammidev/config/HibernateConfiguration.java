package com.sammidev.config;

import com.sammidev.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Slf4j
public class HibernateConfiguration {

    private static final SessionFactory factory;

    static {
        final var registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            MetadataSources metadataSources = new MetadataSources(registry);
            metadataSources.addAnnotatedClass(Student.class);

            factory = metadataSources.buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static Session getSession() throws HibernateException {
        return factory.openSession();
    }

}