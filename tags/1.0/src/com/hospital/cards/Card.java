package com.hospital.cards;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.bridge.builtin.StringBridge;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.module.AnalysisData;
import com.hospital.module.ModuleData;

@Entity
@Indexed(index="indexes/card")
@Table(name = "Card_tbl")
public class Card {
	@Id
	@DocumentId
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_ID")
	@Field(index=Index.TOKENIZED)
	@FieldBridge(impl=StringBridge.class)
	private Patient patient;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_ID")
	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthWorker_ID")
//	@Field(index=Index.TOKENIZED)
//	@FieldBridge(impl=StringBridge.class)
	@IndexedEmbedded
	private HealthWorker healthWorker;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Moule_Data")	
	@IndexColumn(name = "list_order")
	private List<ModuleData> modulesData = new ArrayList<ModuleData>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Analysis_Data")
	@IndexColumn(name = "list_order")
	private List<AnalysisData> analysesData = new ArrayList<AnalysisData>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public HealthWorker getHealthWorker() {
		return healthWorker;
	}

	public void setHealthWorker(HealthWorker healthWorker) {
		this.healthWorker = healthWorker;
	}

	public void addModuleData(ModuleData modulesData) {
		this.modulesData.add(modulesData);
	}

	public List<String> getModuleDataNames() {
		List<String> names = new LinkedList<String>();
		for (Iterator<ModuleData> iterator = modulesData.iterator(); iterator
				.hasNext();) {
			ModuleData moduleData = iterator.next();
			names.add(moduleData.getName());
		}
		return names;
	}

	public ModuleData getModuleData(String name) {
		for (Iterator<ModuleData> iterator = modulesData.iterator(); iterator
				.hasNext();) {
			ModuleData moduleData = iterator.next();
			if (moduleData.getName() == name) {
				return moduleData;
			}
		}
		return null;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<ModuleData> getModulesData() {
		return modulesData;
	}

	public void setModulesData(List<ModuleData> modulesData) {
		this.modulesData = modulesData;
	}

	public List<AnalysisData> getAnalysesData() {
		return analysesData;
	}

	public void setAnalysesData(List<AnalysisData> analysesData) {
		this.analysesData = analysesData;
	}

	public void addAnalysesData(AnalysisData analysesData) {
		this.analysesData.add(analysesData);
	}

}
