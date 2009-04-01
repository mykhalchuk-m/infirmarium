package com.hospital.modulecreator.field;

public class Norm {

	private long idNorm;
	private String unit;
	private double minValue;
	private double maxValue;
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
