package com.hospital.modulecreator;

public class Record {
	private long id;
	private Field field;

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
