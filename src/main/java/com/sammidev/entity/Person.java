package com.sammidev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    private Long id;

    @Column(name = "name", length = 35)
    private String name;

    @Column(name = "year_of_incoming", length = 4, columnDefinition = "int check(year_of_incoming >= 2020)")
    private Integer year;
}