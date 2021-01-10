package com.sammidev.entity;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lecture.class)
public abstract class Lecture_ {

	public static volatile SingularAttribute<Lecture, LocalDateTime> lastUpdatedBy;
	public static volatile SingularAttribute<Lecture, String> nip;
	public static volatile SingularAttribute<Lecture, String> createdBy;
	public static volatile SingularAttribute<Lecture, String> name;
	public static volatile SingularAttribute<Lecture, LocalDateTime> createdDateTime;
	public static volatile SingularAttribute<Lecture, String> id;
	public static volatile SingularAttribute<Lecture, String> lastUpdateBy;

	public static final String LAST_UPDATED_BY = "lastUpdatedBy";
	public static final String NIP = "nip";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String CREATED_DATE_TIME = "createdDateTime";
	public static final String ID = "id";
	public static final String LAST_UPDATE_BY = "lastUpdateBy";

}

