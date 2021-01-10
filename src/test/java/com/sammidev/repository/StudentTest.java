package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.Student;
import com.sammidev.repository.impl.StudentService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class StudentTest extends TestCase {

    private Session session;
    private StudentService studentRepository;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.studentRepository = new StudentService(session);
    }

    @Test
    public void testSave() {
        var student = Student.builder()
                .id(1L)
                .nim("11111111")
                .name("sammi aldhi yanto")
                .yearOfIncoming(2020)
                .active(true)
                .createdBy("admin")
                .dateOfBirth(LocalDate.of(2001,10,20))
                .createdDate(LocalDateTime.now())
                .build();

        this.session.beginTransaction();
        this.studentRepository.save(student);
        this.session.getTransaction().commit();

        log.info("Student saved : {}", student);
    }

    @Test
    public void testUpdate() {
        var student = Student.builder()
                .id(1L)
                .nim("22222222")
                .name("Sammidev")
                .yearOfIncoming(2020)
                .active(true)
                .createdBy("admin")
                .dateOfBirth(LocalDate.of(2001,10,20))
                .createdDate(LocalDateTime.now())
                .build();

        this.session.beginTransaction();
        this.studentRepository.update(student);
        this.session.getTransaction().commit();

        log.info("student was updated: {}", student);
    }


    @Test
    public void testSFindById() {
        this.session.beginTransaction();
        Optional<Student> studentOptional = this.studentRepository.findById(1L);
        assertTrue("object student not null", studentOptional.isPresent());
        log.info("student by id: {}", studentOptional.orElse(null));
    }

    public void testdelete() {
        this.session.beginTransaction();

        var student = this.session.get(Student.class, 1L);
        this.studentRepository.remove(student);

        this.session.getTransaction().commit();
        log.info("student was delete: {}", student);
    }

    @Override
    public void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
