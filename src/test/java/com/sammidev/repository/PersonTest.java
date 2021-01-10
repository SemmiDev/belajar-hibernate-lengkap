package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.Person;
import com.sammidev.repository.impl.PersonService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;


@Slf4j
public class PersonTest extends TestCase {

    private Session session;
    private PersonService personService;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.personService = new PersonService(session);
    }

    @Test
    public void testInsertValid() {
        var check = Person.builder()
                .id(1L)
                .name("sammidev")
                .year(2020)
                .build();

        this.session.beginTransaction();
        this.personService.save(check);
        this.session.getTransaction().commit();
    }

    @Test
    public void testInsertInvalid() {
        var check = Person.builder()
                .id(1L)
                .name("sammidev")
                .year(2018)
                .build();

        this.session.beginTransaction();
        this.personService.save(check);
        this.session.getTransaction().commit();
    }

    @Override
    public void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
