package com.hospital.modulecreator.field;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="norm_field_tbl")
public class Norm {

	@Id
	@GeneratedValue
	private long idNorm;
	@Basic
	private String unit;
	@Basic
	private double minValue;
	@Basic
	private double maxValue;
	@OneToOne(fetch=FetchType.LAZY, mappedBy="norm")
	//@JoinColumn(name="norm")
	private Field field;

	public long getIdNorm() {
		return idNorm;
	}

	public void setIdNorm(long idNorm) {
		this.idNorm = idNorm;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

}
