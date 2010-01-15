package com.hospital.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hospital.cards.Card;
import com.hospital.hr.BloodGroup;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;

public class DbService {

	public static List<String> getBloodGroupsName() {

		DaoManager<BloodGroup> daoManager = new DaoManager<BloodGroup>();

		List<BloodGroup> bloodGroups = daoManager.getInstance(BloodGroup.class,
				new ArrayList<Param>());

//		daoManager.close();

		List<String> bloodGroupsName = new ArrayList<String>();
		for (Iterator<BloodGroup> iterator = bloodGroups.iterator(); iterator
				.hasNext();) {
			bloodGroupsName.add(iterator.next().getBloodGroupValue());
		}

		return bloodGroupsName;

	}

	public static BloodGroup getBloodGroupByName(String name) {

		DaoManager<BloodGroup> daoManager = new DaoManager<BloodGroup>();

		List<Param> params = new ArrayList<Param>();
		Param paramName = new Param();
		paramName.setParamName("bloodGroupValue");
		paramName.setParamValue(name);
		params.add(paramName);

		List<BloodGroup> bloodGroups = daoManager.getInstance(BloodGroup.class,
				params);

//		daoManager.close();

		Iterator<BloodGroup> iterator = bloodGroups.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static List<BloodGroup> getBloodGroups() {

		DaoManager<BloodGroup> daoManager = new DaoManager<BloodGroup>();

		List<BloodGroup> bloodGroups = daoManager.getInstance(BloodGroup.class,
				new ArrayList<Param>());

//		daoManager.close();

		return bloodGroups;

	}

	public static List<Patient> getPatients() {

		DaoManager<Patient> daoManager = new DaoManager<Patient>();

		List<Patient> patients = daoManager.getInstance(Patient.class,
				new ArrayList<Param>());

//		daoManager.close();

		return patients;

	}

	public static List<Department> getDepartments() {

		DaoManager<Department> daoManager = new DaoManager<Department>();

		List<Department> departments = daoManager.getInstance(Department.class,
				new ArrayList<Param>());

//		daoManager.close();

		return departments;

	}

	public static List<String> getDepartmentsNames() {
		List<String> departmentsNames = new ArrayList<String>();
		for (Iterator<Department> iterator = DbService.getDepartments()
				.iterator(); iterator.hasNext();) {
			departmentsNames.add(iterator.next().getName());

		}
		return departmentsNames;
	}

	public static Department getDepartmentByName(String name) {

		DaoManager<Department> daoManager = new DaoManager<Department>();

		List<Param> params = new ArrayList<Param>();
		addNotEmptyParam("name", name, params);

		List<Department> departments = daoManager.getInstance(Department.class,
				params);

//		//daoManager.close();

		Iterator<Department> iterator = departments.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static Department getDepartmentById(long id) {

		DaoManager<Department> daoManager = new DaoManager<Department>();

		List<Param> params = new ArrayList<Param>();
		Param param = new Param();
		param.setParamName("id");
		param.setParamValue(new Long(id));
		params.add(param);

		List<Department> departments = daoManager.getInstance(Department.class,
				params);

//		//daoManager.close();

		Iterator<Department> iterator = departments.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static Module getModuleById(long id) {

		DaoManager<Module> daoManager = new DaoManager<Module>();

		List<Param> params = new ArrayList<Param>();
		Param param = new Param();
		param.setParamName("id");
		param.setParamValue(new Long(id));
		params.add(param);

		List<Module> modules = daoManager.getInstance(Module.class, params);

		//daoManager.close();

		Iterator<Module> iterator = modules.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}
	public static Analysis getAnalysisById(long id) {

		DaoManager<Analysis> daoManager = new DaoManager<Analysis>();

		List<Param> params = new ArrayList<Param>();
		Param param = new Param();
		param.setParamName("id");
		param.setParamValue(new Long(id));
		params.add(param);

		List<Analysis> modules = daoManager.getInstance(Analysis.class, params);

		//daoManager.close();

		Iterator<Analysis> iterator = modules.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static Card getCardById(int id) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();
		Param param = new Param();
		param.setParamName("id");
		param.setParamValue(new Integer(id));
		params.add(param);

		List<Card> cards = daoManager.getInstance(Card.class, params);

		//daoManager.close();

		Iterator<Card> iterator = cards.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static Patient getPatientById(long id) {

		DaoManager<Patient> daoManager = new DaoManager<Patient>();

		List<Param> params = new ArrayList<Param>();
		Param param = new Param();
		param.setParamName("id");
		param.setParamValue(new Long(id));
		params.add(param);

		List<Patient> departments = daoManager.getInstance(Patient.class,
				params);

		//daoManager.close();

		Iterator<Patient> iterator = departments.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static HealthWorker getRegisteredHealthWorker(String login,
			String password) {

		DaoManager<HealthWorker> daoManager = new DaoManager<HealthWorker>();

		List<Param> params = new ArrayList<Param>();

		Param loginParam = new Param();
		loginParam.setParamName("login");
		loginParam.setParamValue(login);
		params.add(loginParam);

		Param passwordParam = new Param();
		passwordParam.setParamName("password");
		passwordParam.setParamValue(password);
		params.add(passwordParam);

		List<HealthWorker> healthWorkers = daoManager.getInstance(
				HealthWorker.class, params);

		//daoManager.close();

		Iterator<HealthWorker> iterator = healthWorkers.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}

	}

	public static List<Card> getCardsByParams(Patient patient,
			HealthWorker healthWorker, Department department) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("patient", patient, params);
		addNotNullParam("healthWorker", healthWorker, params);
		addNotNullParam("department", department, params);

		List<Card> cards = daoManager.getInstance(Card.class, params);
		//daoManager.close();

		return cards;
	}

	public static List<Card> getCardsByDepartment(Department department) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("department", department, params);

		List<Card> cards = daoManager.getInstance(Card.class, params);

		//daoManager.close();

		return cards;
	}

	public static List<Card> getCardsByHealthWorker(HealthWorker healthWorker) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("healthWorker", healthWorker, params);

		List<Card> cards = daoManager.getInstance(Card.class, params);

		//daoManager.close();

		return cards;
	}

	public static List<Card> getCardsByPatient(Patient patient) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("patient", patient, params);

		List<Card> cards = daoManager.getInstance(Card.class, params);

		//daoManager.close();

		return cards;
	}

	public static List<Card> getCardsByDate(Date start, Date end) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("start", start, params);
		addNotNullParam("end", end, params);

		List<Card> cards = daoManager.getInstance(Card.class, params);

		//daoManager.close();

		return cards;
	}

	public static List<HealthWorker> getExistHealthWorkers() {

		DaoManager<HealthWorker> daoManager = new DaoManager<HealthWorker>();

		List<Param> params = new ArrayList<Param>();

		Param existParam = new Param();
		existParam.setParamName("exist");
		existParam.setParamValue(Boolean.TRUE);
		params.add(existParam);

		List<HealthWorker> healthWorkers = daoManager.getInstance(
				HealthWorker.class, params);

		//daoManager.close();

		return healthWorkers;
	}

	public static List<Module> getExistModules() {

		DaoManager<Module> daoManager = new DaoManager<Module>();

		List<Param> params = new ArrayList<Param>();

		Param existParam = new Param();
		existParam.setParamName("exist");
		existParam.setParamValue(Boolean.TRUE);
		params.add(existParam);

		List<Module> modules = daoManager.getInstance(Module.class, params);

		//daoManager.close();

		return modules;
	}

	public static List<Module> getAllModules() {

		DaoManager<Module> daoManager = new DaoManager<Module>();

		List<Module> modules = daoManager.getInstance(Module.class,
				new ArrayList<Param>());

		//daoManager.close();

		return modules;
	}

	public static List<Analysis> getExistAnalyses() {

		DaoManager<Analysis> daoManager = new DaoManager<Analysis>();

		List<Param> params = new ArrayList<Param>();

		Param existParam = new Param();
		existParam.setParamName("exist");
		existParam.setParamValue(Boolean.TRUE);
		params.add(existParam);

		List<Analysis> analyses = daoManager
				.getInstance(Analysis.class, params);

		//daoManager.close();

		return analyses;
	}

	public static List<HealthWorker> getExistHealthWorkersByName(
			String firstName, String lastName, String middleName) {

		DaoManager<HealthWorker> daoManager = new DaoManager<HealthWorker>();

		List<Param> params = getListParamsByName(firstName, lastName,
				middleName);

		Param existParam = new Param();
		existParam.setParamName("exist");
		existParam.setParamValue(Boolean.TRUE);
		params.add(existParam);

		List<HealthWorker> healthWorkers = daoManager.getInstance(
				HealthWorker.class, params);

		//daoManager.close();

		return healthWorkers;
	}

	public static List<Patient> getPatientsByName(String firstName,
			String lastName, String middleName) {

		DaoManager<Patient> daoManager = new DaoManager<Patient>();

		List<Param> params = getListParamsByName(firstName, lastName,
				middleName);

		List<Patient> patients = daoManager.getInstance(Patient.class, params);

		//daoManager.close();

		return patients;
	}

	private static List<Param> getListParamsByName(String firstName,
			String lastName, String middleName) {
		List<Param> params = new ArrayList<Param>();

		addNotEmptyParam("firstName", firstName, params);

		addNotEmptyParam("lastName", lastName, params);

		addNotEmptyParam("middleName", middleName, params);

		return params;
	}

	private static void addNotEmptyParam(String paramName, String paramValue,
			List<Param> params) {
		if (paramValue != null && !paramValue.equals("")) {
			Param param = new Param();
			param.setParamName(paramName);
			param.setParamValue(paramValue);
			params.add(param);
		}
	}

	private static void addNotNullParam(String paramName, Object paramValue,
			List<Param> params) {
		if (paramValue != null) {
			Param param = new Param();
			param.setParamName(paramName);
			param.setParamValue(paramValue);
			params.add(param);
		}
	}

}
