package com.infirmarium.core.persistance.domain.field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;
import com.infirmarium.core.persistance.domain.module.ModuleDef;

@Entity
@Table(name = FieldDef.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FieldDef extends BaseLongEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = FieldDef.Columns.TEXT)
	private String text;
	@Column(name = FieldDef.Columns.HINT)
	private String hint;
	@Column(name = FieldDef.Columns.ADDITIONAL_INFO)
	private String additionalInfo;
	@Column(name = FieldDef.Columns.TYPE)
	private FieldType type;
	@Column(name = FieldDef.Columns.IS_DELETED)
	private boolean isDeleted;
	@ManyToOne(targetEntity = ModuleDef.class)
	@JoinColumn(name = Columns.MODULE_DEF_ID)
	private ModuleDef moduleDef;

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "module_defs";

	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String TEXT = "text";
		public static final String HINT = "hint";
		public static final String ADDITIONAL_INFO = "additional_info";
		public static final String TYPE = "type";
		public static final String IS_DELETED = "is_deleted";
		public static final String MODULE_DEF_ID = "module_def_id";
	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String TEXT = "text";
		public static final String HINT = "hint";
		public static final String ADDITIONAL_INFO = "additionalInfo";
		public static final String TYPE = "type";
		public static final String IS_DELETED = "isDeleted";
		public static final String MODULE_DEF = "moduleDef";

	}
}
