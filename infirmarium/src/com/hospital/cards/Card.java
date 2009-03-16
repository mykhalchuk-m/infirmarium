package com.hospital.cards;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.module.ModuleData;

public class Card {
	private int id;
	private Date start;
	private Date end;
	private Patient patient;
	private Department department;
	private HealthWorker healthWorker;
	private Set<ModuleData> modulesData = new HashSet<ModuleData>();

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

	public void addModuleData(ModuleData moduleData) {
		modulesData.add(moduleData);
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

	public Set<ModuleData> getModulesData() {
		return modulesData;
	}

	public void setModulesData(Set<ModuleData> modulesData) {
		this.modulesData = modulesData;
	}
}
