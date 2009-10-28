package com.hospital.modulecreator.field;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "field_tbl")
public class Field {
	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String name;
	@Enumerated(EnumType.STRING)
	private FieldTypes type;

	@CollectionOfElements
	@JoinTable(name = "List_Field_Values_tbl", joinColumns = @JoinColumn(name = "id_Fields_Values"))
	@IndexColumn(name = "list_order")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> values = new ArrayList<String>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "norm")
	private Norm norm;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sexNorm")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
