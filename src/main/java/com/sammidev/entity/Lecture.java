package com.sammidev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "lecture",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "un_nip",
                        columnNames = "nip"
                )
        }
)
public class Lecture {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "nip", length = 10)
    private String nip;

    @Column(name = "created_by", length = 100, nullable = false)
    private String createdBy;

    @Column(name = "last_updated_by", length = 100)
    private String lastUpdateBy;

    @Column(name = "created_datetime", nullable = false)
    private LocalDateTime createdDateTime;

    @Column(name = "last_updated_datetime")
    private LocalDateTime lastUpdatedBy;
}