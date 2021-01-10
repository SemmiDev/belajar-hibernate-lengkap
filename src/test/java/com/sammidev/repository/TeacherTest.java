package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.Employee;
import com.sammidev.entity.Teacher;
import com.sammidev.repository.impl.EmployeeService;
import com.sammidev.repository.impl.TeacherService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

@Slf4j
public class TeacherTest extends TestCase {

    private Session session;
    private TeacherService teacherService;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.teacherService = new TeacherService(session);
    }

    @Test
    public void testInsertValid() {

        var check = Teacher.builder().email("sammidev@gmal.com").build();

        this.session.beginTransaction();
        check = this.teacherService.save(check);
        log.info("inserted value: {}", check);
        this.session.getTransaction().commit();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
