package com.sammidev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    private Long id;

    @Column(name = "student_nim", nullable = false, unique = true, length = 8)
    private String nim;

    @Column(name = "student_name", nullable = false, length = 25)
    private String name;

    @Column(name = "year_of_incoming", length = 4)
    private Integer yearOfIncoming;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "is_active")
    private Boolean active;

    @Type(type = "text")
    @Column(name = "bio")
    private String biodata;
}