package com.hospital.hr;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed(index="indexed/patient")
@Table(name = "patients_tbl")
public class Patient implements Serializable {	
	private static final long serialVersionUID = 1L;
	@Id
	@DocumentId
	@GeneratedValue
	private long id;
	@Basic
	@Column(name = "first_Name")
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String firstName;
	@Basic
	@Column(name = "middle_Name")
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String middleName;
	@Basic
	@Column(name = "last_Name")
	@Field(index=Index.TOKENIZED, store=Store.YES)
	private String lastName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address")
	@IndexedEmbedded(prefix="address.")
	private Address address;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Enumerated(EnumType.STRING)
	private SexTypes sex;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bloodGroup_ID")
	private BloodGroup bloodGroup;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public SexTypes getSex() {
		return sex;
	}

	public void setSex(SexTypes sex) {
		this.sex = sex;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String toString() {
		return firstName + " " + lastName + " " + middleName; 
	}
}
