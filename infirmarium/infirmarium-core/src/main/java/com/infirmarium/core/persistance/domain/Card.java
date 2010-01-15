package com.infirmarium.core.persistance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.core.BaseLongEntity;
import com.infirmarium.core.persistance.domain.module.ModuleValue;

@Entity
@Table(name = Card.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "modulesData" })
@ToString(callSuper = true, exclude = { "modulesData" })
public class Card extends BaseLongEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
	@JoinColumn(name = Columns.PATIENT_ID)
	private Person patient;
	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
	@JoinColumn(name = Columns.DOCTOR_ID)
	private Person doctor;
	@OneToMany(mappedBy = ModuleValue.Fields.CARD)
	private List<ModuleValue> modulesData = new ArrayList<ModuleValue>();
	@ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
	@JoinColumn(name = Columns.DEPARTMENT)
	private Department department;
	@Column(name = Card.Columns.START)
	private Date start;
	@Column(name = Card.Columns.END)
	private Date end;

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "card";
	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String PATIENT_ID = "patient_id";
		public static final String DOCTOR_ID = "doctor_id";
		public static final String DEPARTMENT = "department_id";
		public static final String START = "start_date";
		public static final String END = "end_date";
	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String PATIENT = "patient";
		public static final String DOCTOR = "doctor";
		public static final String MODULES_DATA = "modulesData";
		public static final String DEPARTMENT = "department";
		public static final String START = "start";
		public static final String END = "end";
	}
}
