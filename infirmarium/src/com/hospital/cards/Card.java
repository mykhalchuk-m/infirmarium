package com.hospital.cards;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.module.AnalysisData;
import com.hospital.module.ModuleData;

public class Card {
	private int id;
	private Date start;
	private Date end;
	private Patient patient;
	private Department department;
	private HealthWorker healthWorker;
	private List<ModuleData> modulesData = new ArrayList<ModuleData>();
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
