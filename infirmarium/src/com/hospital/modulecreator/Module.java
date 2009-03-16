package com.hospital.modulecreator;

import java.util.HashMap;
import java.util.Map;

public class Module {

	private long id;
	private Map<String, Record> parameters = new HashMap<String, Record>();
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public Map<String, Record> getParameters() {
		return parameters;
	}

	public void setParameter(String name, Record value) {
		if (name != null) {
			parameters.put(name, value);
		}
	}

	public Record getParameter(String name) {
		return parameters.get(name);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setParameters(Map<String, Record> parameters) {
		this.parameters = parameters;
	}

}
