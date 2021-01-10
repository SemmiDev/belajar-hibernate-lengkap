package com.sammidev.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "employee"
)
@SequenceGenerator(
        name = "seq_gen_employee",
        allocationSize = 1,
        sequenceName = "seq_employee",
        initialValue = 1
)
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_gen_employee")
    private Long id;

    @Column(name = "nama", length = 25)
    private String name;
}