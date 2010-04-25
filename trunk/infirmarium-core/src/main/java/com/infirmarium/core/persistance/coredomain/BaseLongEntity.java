package com.infirmarium.core.persistance.coredomain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import net.sf.gilead.pojo.gwt.LightEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false, of = { "primaryKey" })
public abstract class BaseLongEntity extends LightEntity implements
		BaseEntity<Long> {

	@Id
	@GeneratedValue
	@Column(name = Columns.ID)
	protected Long primaryKey;

	public static class Constants extends BaseEntity.Constants {
	}

	public static class Columns extends BaseEntity.Columns {

		public static final String ID = "id";
	}

	public static class Fields extends BaseEntity.Fields {

		public static final String ID = Columns.ID;
	}
}
