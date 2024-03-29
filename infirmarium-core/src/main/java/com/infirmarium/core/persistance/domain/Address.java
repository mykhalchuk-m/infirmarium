package com.infirmarium.core.persistance.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;

@Entity
@Table(name = Address.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "owners" })
@ToString(callSuper = true, exclude = { "owners" })
public class Address extends BaseLongEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = Address.Columns.COUNTRY)
	private String country;
	@Column(name = Address.Columns.REGION)
	private String region;
	@Column(name = Address.Columns.DISTRICT)
	private String district;
	@Column(name = Address.Columns.CITY)
	private String city;
	@Column(name = Address.Columns.STREET)
	private String street;
	@Column(name = Address.Columns.HOUSE)
	private String house;
	@Column(name = Address.Columns.FLAT)
	private String flat;
	@ManyToMany(targetEntity = Person.class, mappedBy = Person.Fields.ADRESSES)
	private List<Person> owners = new LinkedList<Person>();

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "address";
	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String COUNTRY = "country";
		public static final String REGION = "region";
		public static final String DISTRICT = "district";
		public static final String CITY = "city";
		public static final String STREET = "street";
		public static final String HOUSE = "house";
		public static final String FLAT = "flat";
	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String COUNTRY = "country";
		public static final String REGION = "region";
		public static final String DISTRICT = "district";
		public static final String CITY = "city";
		public static final String STREET = "street";
		public static final String HOUSE = "house";
		public static final String FLAT = "flat";
		public static final String OWNERS = "owners";
	}
}
