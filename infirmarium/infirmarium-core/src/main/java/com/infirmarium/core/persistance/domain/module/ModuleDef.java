package com.infirmarium.core.persistance.domain.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.core.BaseLongEntity;
import com.infirmarium.core.persistance.domain.Department;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.persistance.domain.field.FieldDef;


@Entity
@Table(name = ModuleDef.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "fieldDefs",
		"assignedDepartments" })
@ToString(callSuper = true, exclude = { "fieldDefs", "assignedDepartments" })
@SuppressWarnings("serial")
public class ModuleDef extends BaseLongEntity {

	@Column(name = ModuleDef.Columns.NAME)
	private String name;
	@Column(name = ModuleDef.Columns.DESCRIPTION)
	private String description;
	@Column(name = ModuleDef.Columns.CREATION_DATE)
	private Date creationDate;
	@ManyToOne(targetEntity = Person.class)
	@JoinColumn(name = Columns.CREATOR_ID)
	private Person creator;
	@Column(name = ModuleDef.Columns.IS_DELETED)
	private boolean isDeleted;
	@OneToMany(mappedBy = FieldDef.Fields.MODULE_DEF)
	private List<FieldDef> fieldDefs = new ArrayList<FieldDef>();
	@ManyToMany(targetEntity = Department.class, mappedBy = Department.Fields.MODULE_DEFS)
	private List<Department> assignedDepartments = new LinkedList<Department>();

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "module_defs";

	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String NAME = "name";
		public static final String DESCRIPTION = "description";
		public static final String CREATION_DATE = "creation_date";
		public static final String CREATOR_ID = "creator_id";
		public static final String IS_DELETED = "is_deleted";

	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String NAME = "name";
		public static final String DESCRIPTION = "description";
		public static final String CREATION_DATE = "creationDate";
		public static final String CREATOR = "creator";
		public static final String IS_DELETED = "isDeleted";
		public static final String FIELD_DEFS = "fieldDefs";
		public static final String ASSIGNED_DEPARTMENTS = "assignedDepartments";

	}
}
