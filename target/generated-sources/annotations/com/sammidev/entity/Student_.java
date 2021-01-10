package com.sammidev.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, String> nim;
	public static volatile SingularAttribute<Student, LocalDateTime> createdDate;
	public static volatile SingularAttribute<Student, String> createdBy;
	public static volatile SingularAttribute<Student, Integer> yearOfIncoming;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, String> biodata;
	public static volatile SingularAttribute<Student, Boolean> active;
	public static volatile SingularAttribute<Student, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<Student, Long> id;

	public static final String NIM = "nim";
	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String YEAR_OF_INCOMING = "yearOfIncoming";
	public static final String NAME = "name";
	public static final String BIODATA = "biodata";
	public static final String ACTIVE = "active";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String ID = "id";

}

