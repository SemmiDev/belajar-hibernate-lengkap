package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.CustomerID;
import com.sammidev.entity.Lecture;
import com.sammidev.entity.Product;
import com.sammidev.entity.ProductID;
import com.sammidev.repository.impl.ProductService;
import com.sammidev.repository.impl.TeacherService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class ProductTest extends TestCase {
    private Session session;
    private ProductService productService;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.productService = new ProductService(session);
    }

    @Test
    public void testSave() {
        var check = Product.builder()
                .id(1)
                .code("code")
                .name("sammidev")
                .build();

        this.session.beginTransaction();
        this.productService.save(check);
        this.session.getTransaction().commit();
    }

    @Test
    public void testFindById() {
        var pk = ProductID.builder()
                .code("code")
                .id(1)
                .build();

        this.session.beginTransaction();
        Optional<Product> classRoomOptional = this.productService.findById(pk);
        assertTrue("classroom is present", classRoomOptional.isPresent());
        log.info("classroom: {}", classRoomOptional.orElse(null));
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }

}
