package com.sammidev.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CustomerID implements Serializable {

    @Column(name = "class_id")
    private String classId;

    @Column(name = "year",
            length = 4,
            columnDefinition = "int check(year >= 2001)")
    private Integer year;

}