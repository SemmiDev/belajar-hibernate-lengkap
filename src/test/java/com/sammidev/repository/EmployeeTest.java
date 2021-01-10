package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.Employee;
import com.sammidev.repository.impl.EmployeeService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

@Slf4j
public class EmployeeTest extends TestCase {

    private Session session;
    private EmployeeService employeeService;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.employeeService = new EmployeeService(session);
    }

    @Test
    public void testInsertValid() {
        var check = Employee.builder()
                .name("sammidev")
                .build();

        this.session.beginTransaction();
        check = this.employeeService.save(check);
        log.info("inserted value: {}", check);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}