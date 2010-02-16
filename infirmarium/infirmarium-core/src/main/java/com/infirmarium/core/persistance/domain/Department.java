package com.infirmarium.core.persistance.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;
import com.infirmarium.core.persistance.domain.module.ModuleDef;

@Entity
@Table(name = Department.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "moduleDefs", "doctors" })
@ToString(callSuper = true, exclude = { "moduleDefs", "doctors" })
@SuppressWarnings("serial")
public class Department extends BaseLongEntity {

	@Column(name = Department.Columns.NAME)
	private String name;
	@OneToMany(mappedBy = Person.Fields.DEPARTMENT)
	private List<Person> doctors = new LinkedList<Person>();
	@ManyToMany(targetEntity = ModuleDef.class)
	@JoinTable(name = Constants.DepartmentModuleDefConstants.TABLE_NAME, joinColumns = { @JoinColumn(name = Columns.DepartmentModuleDefColumns.DEPARTMETN_ID) }, inverseJoinColumns = { @JoinColumn(name = Columns.DepartmentModuleDefColumns.MODULE_DEF_ID) })
	private List<ModuleDef> moduleDefs = new LinkedList<ModuleDef>();

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "department";

		public static class DepartmentModuleDefConstants extends
				BaseLongEntity.Constants {
			public static final String TABLE_NAME = "department_module_def";
		}

	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String NAME = "name";

		public static class DepartmentModuleDefColumns extends
				BaseLongEntity.Columns {
			public static final String DEPARTMETN_ID = "department_id";
			public static final String MODULE_DEF_ID = "module_def_id";
		}
	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String NAME = "name";
		public static final String DOCTORS = "doctors";
		public static final String MODULE_DEFS = "moduleDefs";
	}
}
