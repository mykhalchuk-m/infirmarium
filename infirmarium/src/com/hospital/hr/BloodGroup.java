package com.hospital.hr;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodgroup_tbl")
public class BloodGroup {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Basic
	@Column(name="blood_Group_Value")
	private String bloodGroupValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBloodGroupValue() {
		return bloodGroupValue;
	}

	public void setBloodGroupValue(String bloodGroupValue) {
		this.bloodGroupValue = bloodGroupValue;
	}

}
