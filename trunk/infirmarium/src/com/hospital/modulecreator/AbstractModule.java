package com.hospital.modulecreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hospital.modulecreator.field.Field;

public abstract class AbstractModule {

	private long id;
	private List<Field> parameters = new ArrayList<Field>();
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setParameter(Field field) {
		if (field != null) {
			parameters.add(field);
		}
	}

	public Field getParameter(String name) {
		for (Iterator<Field> iterator = parameters.iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
			if (field.getName().equals(name)) {
				return field;
			}
		}
		return null;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Field> getParameters() {
		return parameters;
	}

	public void setParameters(List<Field> parameters) {
		this.parameters = parameters;
	}

}
