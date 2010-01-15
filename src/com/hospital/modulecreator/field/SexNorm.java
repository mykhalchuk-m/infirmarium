package com.hospital.modulecreator.field;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sex_norm_field_tbl")
public class SexNorm {

	@Id
	@GeneratedValue
	private long idSexNorm;
	@Basic
	private String unit;
	@Basic
	private double minMaleValue;
	@Basic
	private double maxMaleValue;
	@Basic
	private double minFemaleValue;
	@Basic
	private double maxFemaleValue;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="sexNorm")
	private Field field;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getMinMaleValue() {
		return minMaleValue;
	}

	public void setMinMaleValue(double minMaleValue) {
		this.minMaleValue = minMaleValue;
	}

	public double getMaxMaleValue() {
		return maxMaleValue;
	}

	public void setMaxMaleValue(double maxMaleValue) {
		this.maxMaleValue = maxMaleValue;
	}

	public double getMinFemaleValue() {
		return minFemaleValue;
	}

	public void setMinFemaleValue(double minFemaleValue) {
		this.minFemaleValue = minFemaleValue;
	}

	public double getMaxFemaleValue() {
		return maxFemaleValue;
	}

	public void setMaxFemaleValue(double maxFemaleValue) {
		this.maxFemaleValue = maxFemaleValue;
	}

	public long getIdSexNorm() {
		return idSexNorm;
	}

	public void setIdSexNorm(long idSexNorm) {
		this.idSexNorm = idSexNorm;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

}
