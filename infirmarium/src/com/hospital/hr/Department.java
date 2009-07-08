package com.hospital.hr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;

public class Department {
	private long id;
	private String name;
	private Set<Module> modules = new HashSet<Module>();
	private Set<Analysis> analyses = new HashSet<Analysis>();
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

	public Set<Module> getExistModule() {
		Set<Module> existModules = new HashSet<Module>();
		for (Iterator<Module> iterator = modules.iterator(); iterator.hasNext();) {
			Module module = iterator.next();
			if (module.getExist()) {
				existModules.add(module);
			}

		}
		return existModules;
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

	public Set<HealthWorker> getExistHealthWorkers() {
		Set<HealthWorker> existHealthWorkers = new HashSet<HealthWorker>();
		for (Iterator<HealthWorker> iterator = healthWorkers.iterator(); iterator
				.hasNext();) {
			HealthWorker healthWorker = iterator.next();
			if (healthWorker.getExist()) {
				existHealthWorkers.add(healthWorker);
			}

		}
		return existHealthWorkers;
	}

	public void setHealthWorkers(Set<HealthWorker> healthWorkers) {
		this.healthWorkers = healthWorkers;
	}

	public void addHealthWorker(HealthWorker healthWorker) {
		this.healthWorkers.add(healthWorker);
	}

	public Set<Analysis> getAnalyses() {
		return analyses;
	}

	public Set<Analysis> getExistAnalyses() {
		Set<Analysis> existAnalyses = new HashSet<Analysis>();
		for (Iterator<Analysis> iterator = analyses.iterator(); iterator
				.hasNext();) {
			Analysis analysis = iterator.next();
			if (analysis.getExist()) {
				existAnalyses.add(analysis);
			}

		}
		return existAnalyses;
	}

	public void setAnalyses(Set<Analysis> analyses) {
		this.analyses = analyses;
	}

	public void addAnalysis(Analysis analysis) {
		this.analyses.add(analysis);
	}
}
