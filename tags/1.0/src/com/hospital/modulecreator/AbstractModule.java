package com.hospital.modulecreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import com.hospital.modulecreator.field.Field;

@Entity
@Table(name = "abstract_module_tbl")
public abstract class AbstractModule {

	@Id
	@GeneratedValue
	private long id;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_parameters")
	@IndexColumn(name = "list_parameters_order")
	private List<Field> parameters = new ArrayList<Field>();
	@Basic
	private String moduleName;
	@Basic
	private Boolean exist = Boolean.TRUE;

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

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public int hashCode() {
		return (int) (moduleName.hashCode() * id);
	}

	public boolean equals(Object o) {
		return hashCode() == ((AbstractModule) o).hashCode();
	}

}
