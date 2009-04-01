package com.hospital.modulecreator;

import java.util.HashMap;
import java.util.Map;

import com.hospital.modulecreator.field.Field;

public abstract class AbstractModule {

	private long id;
	private Map<String, Field> parameters = new HashMap<String, Field>();
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Map<String, Field> getParameters() {
		return parameters;
	}

	public void setParameter(String name, Field value) {
		if (name != null) {
			parameters.put(name, value);
		}
	}

	public Field getParameter(String name) {
		return parameters.get(name);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setParameters(Map<String, Field> parameters) {
		this.parameters = parameters;
	}

}
