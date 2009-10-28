package com.hospital.hr;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed(index="indexes/healthworker")
@Table(name="healthworker_tbl")
public class HealthWorker {
	@Id
	@DocumentId
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Basic
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String firstName;
	@Basic
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String middleName;
	@Basic
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String lastName;
	@Basic
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String speciality;
	@Basic
	private String login;
	@Basic
	private String password;
	@Basic
	private Boolean exist = Boolean.TRUE;
	@Enumerated(EnumType.STRING)
	private Role role = Role.WORKER;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int hashCode() {
		return (int) ((firstName.hashCode() + lastName.hashCode())* id);
	}

	public boolean equals(Object o) {
		return hashCode() == ((HealthWorker) o).hashCode();
	}
	
	public String toString() {
		return firstName + " " + lastName + " " + middleName + " " + speciality;
	}
}
