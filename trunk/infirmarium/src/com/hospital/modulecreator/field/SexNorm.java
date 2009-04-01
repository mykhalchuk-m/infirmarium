package com.hospital.modulecreator.field;

public class SexNorm {

	private long idSexNorm;
	private String unit;
	private double minMaleValue;
	private double maxMaleValue;
	private double minFemaleValue;
	private double maxFemaleValue;
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
