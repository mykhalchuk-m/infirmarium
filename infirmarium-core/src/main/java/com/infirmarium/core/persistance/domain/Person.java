package com.infirmarium.core.persistance.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;
import com.infirmarium.core.persistance.domain.enums.BloodGroup;
import com.infirmarium.core.persistance.domain.enums.Gender;
import com.infirmarium.core.persistance.domain.enums.Role;

@Entity
@Table(name = Person.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "addresses" })
@ToString(callSuper = true, exclude = { "addresses" })
@SuppressWarnings("serial")
public class Person extends BaseLongEntity {

	// security fields
	@Column(name = Person.Columns.LOGIN)
	private String login;
	@Column(name = Person.Columns.PASSWORD_HASH)
	private String passwordHash;
	@Column(name = Person.Columns.ROLE)
	@Enumerated(value = EnumType.STRING)
	private Role role;

	// personal fields
	@Column(name = Person.Columns.FIRST_NAME)
	private String firstName;
	@Column(name = Person.Columns.MIDDLE_NAME)
	private String middleName;
	@Column(name = Person.Columns.LAST_NAME)
	private String lastName;
	@ManyToMany(targetEntity = Address.class)
	@JoinTable(name = Constants.PersonAddressConstant.TABLE_NAME, joinColumns = { @JoinColumn(name = Columns.PersonAddressColumns.ADDRESS_ID) }, inverseJoinColumns = { @JoinColumn(name = Columns.PersonAddressColumns.PERSON_ID) })
	private List<Address> addresses = new LinkedList<Address>();
	@Column(name = Person.Columns.BIRTHDAY)
	private Date birthday;
	@Column(name = Person.Columns.BLOOD_GROUP)
	@Enumerated(value = EnumType.STRING)
	private BloodGroup bloodGroup;
	@Column(name = Person.Columns.GENDER)
	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	// additional fields
	@Column(name = Person.Columns.SPECIALITY)
	private String speciality;
	@Column(name = Person.Columns.IS_DELETED)
	private Boolean deleted;
	// TODO move this field into additional table
	@ManyToOne(targetEntity = Department.class, fetch = FetchType.LAZY)
	@JoinColumn(name = Columns.DEPARTMENT_ID)
	private Department department;

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "person";

		public static class PersonAddressConstant extends
				BaseLongEntity.Constants {
			public static final String TABLE_NAME = "person_address";

		}
	}

	public static class Columns extends BaseLongEntity.Columns {
		public static final String LOGIN = "login";
		public static final String PASSWORD_HASH = "password_hash";
		public static final String ROLE = "role";

		public static final String FIRST_NAME = "first_name";
		public static final String MIDDLE_NAME = "middle_name";
		public static final String LAST_NAME = "last_name";
		public static final String BIRTHDAY = "birthday";
		public static final String BLOOD_GROUP = "blood_gropu";
		public static final String GENDER = "gender";

		public static final String SPECIALITY = "speciality";
		public static final String IS_DELETED = "is_deleted";
		public static final String DEPARTMENT_ID = "department_id";

		public static class PersonAddressColumns extends BaseLongEntity.Columns {
			public static final String ADDRESS_ID = "address_id";
			public static final String PERSON_ID = "person_id";
		}
	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String LOGIN = "login";
		public static final String PASSWORD_HASH = "passwordHash";
		public static final String ROLE = "role";

		public static final String FIRST_NAME = "firstName";
		public static final String MIDDLE_NAME = "middleName";
		public static final String LAST_NAME = "lastName";
		public static final String ADRESSES = "addresses";
		public static final String BIRTHDAY = "birthday";
		public static final String BLOOD_GROUP = "bloodGroup";
		public static final String GENDER = "gender";

		public static final String SPECIALITY = "speciality";
		public static final String IS_DELETED = "isDeleted";
		public static final String DEPARTMENT = "department";
	}

}
