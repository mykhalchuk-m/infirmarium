package com.hospital.module;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKey;

import com.hospital.modulecreator.AbstractModule;
import com.hospital.modulecreator.field.Field;

@Entity
@Table(name = "moduledata_tbl")
@Inheritance(strategy=InheritanceType.JOINED)
public class ModuleData {
	@Id
	@GeneratedValue
	private long id;

	@Basic
	private String name;

	@CollectionOfElements//(fetch=FetchType.EAGER)
	@JoinTable(name = "parameters_module_data_tbl", joinColumns = @JoinColumn(name = "id"))
	@MapKey(columns = {@Column(name = "parameter_name")})
	@Column(name = "parameter_value")
	private Map<String, String> parameters = new HashMap<String, String>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
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
