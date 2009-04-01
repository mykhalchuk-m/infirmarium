package com.hospital.modulecreator.field;

import java.util.ArrayList;
import java.util.List;

public class Field {
	private long id;
	private FieldTypes type;
	private List<String> values = new ArrayList<String>();
	private Norm norm;
	private SexNorm sexNorm;

	public FieldTypes getType() {
		return type;
	}

	public void setType(FieldTypes type) {
		this.type = type;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public void addValue(String value) {
		this.values.add(value);
	}

	public Norm getNorm() {
		return norm;
	}

	public void setNorm(Norm norm) {
		this.norm = norm;
	}

	public SexNorm getSexNorm() {
		return sexNorm;
	}

	public void setSexNorm(SexNorm sexNorm) {
		this.sexNorm = sexNorm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
