package com.sammidev.training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
@SequenceGenerator(
        name = "seq_gen_jobs",
        allocationSize = 1,
        sequenceName = "seq_jobs",
        initialValue = 1
)
public class Jobs {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "seq_gen_jobs")
    private Integer code;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Type(type = "text")
    @Column(name = "details")
    private String details;
}
