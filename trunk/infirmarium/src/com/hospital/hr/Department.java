package com.hospital.hr;

import java.util.HashSet;
import java.util.Set;

import com.hospital.modulecreator.Module;

public class Department {
	private long id;
	private String name;
	private Set<Module> modules = new HashSet<Module>();
	private Set<HealthWorker> healthWorkers = new HashSet<HealthWorker>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public void addModule(Module module) {
		this.modules.add(module);
	}

	public Set<HealthWorker> getHealthWorkers() {
		return healthWorkers;
	}

	public void setHealthWorkers(Set<HealthWorker> healthWorkers) {
		this.healthWorkers = healthWorkers;
	}

	public void addHealthWorker(HealthWorker healthWorker) {
		this.healthWorkers.add(healthWorker);
	}

}
