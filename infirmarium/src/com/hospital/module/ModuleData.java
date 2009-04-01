package com.hospital.module;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hospital.modulecreator.AbstractModule;
import com.hospital.modulecreator.field.Field;

public class ModuleData {
	private long id;
	private String name;
	private Map<String, String> parameters = new HashMap<String, String>();
	private Date creationDate;
	private AbstractModule abstractModule;

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

	public void addParameter(String parameterName, String parameterValue) {
		this.parameters.put(parameterName, parameterValue);
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public AbstractModule getAbstractModule() {
		return abstractModule;
	}

	public void setAbstractModule(AbstractModule abstractModule) {
		this.abstractModule = abstractModule;
	}

	public Field getFieldByParamName(String paramName) {
		Field field = null;
		if (getAbstractModule() != null) {

			field = getAbstractModule().getParameter(paramName);

		}
		return field;
	}
}
