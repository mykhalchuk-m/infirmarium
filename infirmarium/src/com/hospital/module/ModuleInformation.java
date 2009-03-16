package com.hospital.module;

import java.util.HashMap;
import java.util.Map;

public class ModuleInformation {
	private long id;
	private String name;
	private Map<String, String> parameters = new HashMap<String, String>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
}
