package com.hospital.modulecreator;

import java.util.Set;

public class Field {
	private long id;
	private FieldTypes type;
	private Set<String> values;

	public FieldTypes getType() {
		return type;
	}

	public void setType(FieldTypes type) {
		this.type = type;
	}

	public Set<String> getValues() {
		return values;
	}

	public void setValues(Set<String> values) {
		this.values = values;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
