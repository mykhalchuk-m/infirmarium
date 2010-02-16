package com.infirmarium.core.persistance.domain.field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.persistance.domain.module.ModuleValue;

@Entity
@Table(name = FieldValue.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FieldValue extends BaseLongEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = Columns.NUMERICAL_VALUE)
	private long numericalValue;
	@Column(name = Columns.STRING_VALUE)
	private String stringValue;
	@Column(name = Columns.TYPE)
	@Enumerated(value = EnumType.STRING)
	private FieldType type;
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = Columns.MODULE_VALUE_ID)
	private ModuleValue moduleValue;
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = Columns.CREATOR_ID)
	private Person creator;

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "field_value";
	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String NUMERICAL_VALUE = "numerical_value";
		public static final String STRING_VALUE = "string_value";
		public static final String TYPE = "type";
		public static final String MODULE_VALUE_ID = "module_value_id";
		public static final String CREATOR_ID = "creator_id";
	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String NUMERICAL_VALUE = "numericalValue";
		public static final String STRING_VALUE = "stringValue";
		public static final String TYPE = "type";
		public static final String MODULE_VALUE = "moduleValue";
		public static final String CREATOR = "creator";
	}
}
