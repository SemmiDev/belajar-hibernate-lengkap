package com.sammidev.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "employees",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "un_nip",
                        columnNames = "nip"
                )
        }
)
@GenericGenerator(name = "uuid_employee_gen", strategy = "uuid2")
public class Employees {

    @Id
    @Column(name = "code", length = 64)
    @GeneratedValue(generator = "uuid_employee_gen")
    private String code;

    @Column(name = "nip", nullable = false, length = 64)
    private String nip;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "date_of_birth", nullable = false, columnDefinition = "date check(date_of_birth <= now())")
    private LocalDate DateOfBirth;

    @Column(name = "salary", nullable = false, columnDefinition = "decimal default 0")
    private BigDecimal SalaryPerMonth;

    @Column(name = "active", columnDefinition = "boolean default false")
    private Boolean active;
}