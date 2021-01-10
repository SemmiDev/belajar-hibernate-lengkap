package com.sammidev.repository;

import com.sammidev.config.HibernateConfiguration;
import com.sammidev.entity.Employee;
import com.sammidev.training.Employees;
import com.sammidev.training.EmployeesService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeesTest extends TestCase {

    private Session session;
    private EmployeesService employeesService;
    private Employees employees;

    @Override
    public void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.employeesService = new EmployeesService(session);

        this.employees = Employees.builder()
                .code(UUID.randomUUID().toString())
                .nip("2003113948")
                .name("sammidev")
                .DateOfBirth(LocalDate.of(2020,10,20))
                .SalaryPerMonth(new BigDecimal(2000000))
                .active(true)
                .build();
    }

    @Test
    public void testASave_1() {
        this.session.beginTransaction();

        this.employees = this.employeesService.save(this.employees);
        log.info("inserted value: {}", employees);

        this.session.getTransaction().commit();
    }

    @Test
    public void testBUpdate_2() {
        var employees = Employees.builder()
                .code("fe636a8a-7fb3-42f5-9114-1e035be0567c")
                .nip("00000")
                .name("sam")
                .DateOfBirth(LocalDate.of(2020,10,20))
                .SalaryPerMonth(new BigDecimal(2000000))
                .active(true)
                .build();

        this.session.beginTransaction();
        this.employeesService.update(employees);

        log.info("employees was updated: {}", employees);
        this.session.getTransaction().commit();
    }

    @Test
    public void testCFindAll_3() {
        this.session.beginTransaction();

        var result = this.employeesService.findAll();
        log.info("employees was updated: {}", result);

        this.session.getTransaction().commit();
    }

    @Test
    public void testDFindById_4() {
        this.session.beginTransaction();

        var result = this.employeesService.findById(this.employees.getCode());
        log.info("employees was found: {}", result);

        this.session.getTransaction().commit();
    }

    @Test
    public void testERemove_5() {

        var employees = Employees.builder()
                .code("fe636a8a-7fb3-42f5-9114-1e035be0567c")
                .nip("00000")
                .name("sam")
                .DateOfBirth(LocalDate.of(2020,10,20))
                .SalaryPerMonth(new BigDecimal(2000000))
                .active(true)
                .build();
        this.session.beginTransaction();
        var a = this.employeesService.remove(employees);
        log.info("employees was removed: {}", a);

        this.session.getTransaction().commit();
    }

    @Test
    public void testRemoveById() {
        this.session.beginTransaction();
        var a = this.employeesService.removeById("bc2eb184-be90-412f-bb0f-894557c1e6f4");
        log.info("employees was removed: {}", a);
        this.session.getTransaction().commit();

    }
}
