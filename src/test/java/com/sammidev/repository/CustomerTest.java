package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.CustomerID;
import com.sammidev.entity.Customerr;
import com.sammidev.repository.impl.CustomerService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

@Slf4j
public class CustomerTest extends TestCase {


    private Session session;
    private CustomerService customerService;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.customerService = new CustomerService(session);
    }

    @Test
    public void testSaveCustomer() {
        var customer = Customerr.builder()
                .customerID(
                        CustomerID.builder()
                                .year(2020)
                                .classId("INI ID")
                                .build()
                )
                .name("sammidev")
                .build();

        this.session.beginTransaction();
        customer =  this.customerService.save(customer);
        this.session.getTransaction().commit();

        log.info("classroom saved: {}", customer);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
