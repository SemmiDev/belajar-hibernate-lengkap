package com.sammidev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ProductID.class)
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "name")
    private String name;
}
