package com.sammidev.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
@GenericGenerator(name = "uuid_teacher_gen", strategy = "uuid2")
public class Teacher {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid_teacher_gen")
    private String id;

    @Column(name = "email", length = 25)
    private String email;

}
