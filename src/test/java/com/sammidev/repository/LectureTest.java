package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.Lecture;
import com.sammidev.repository.impl.LectureService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class LectureTest {

    private Session session;
    private LectureService lectureService;

    @Before
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.lectureService = new LectureService(session);
    }

    @Test
    public void testInsertValid() {
        var check = Lecture.builder()
                .id(UUID.randomUUID().toString())
                .name("sammi")
                .nip("1111111111")
                .createdBy("admmin")
                .createdDateTime(LocalDateTime.now())
                .build();

        this.session.beginTransaction();
        this.lectureService.save(check);
        this.session.getTransaction().commit();
    }

    @Test
    public void testInsertInValid() {
        this.session.beginTransaction();

        var check = Lecture.builder()
                .id(UUID.randomUUID().toString())
                .name("sammidev")
                .nip("1111111111")
                .createdBy("admmin")
                .createdDateTime(LocalDateTime.now())
                .build();

        this.session.beginTransaction();
        this.lectureService.save(check);
        this.session.getTransaction().commit();
        this.lectureService.save(check);


        // invalid because nip was recorded
        check = Lecture.builder()
                .id(UUID.randomUUID().toString())
                .name("sammidev")
                .nip("1111111111")
                .createdBy("admmin")
                .createdDateTime(LocalDateTime.now())
                .build();

        this.lectureService.save(check);
        this.session.getTransaction().commit();
    }

    @After
    public void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}