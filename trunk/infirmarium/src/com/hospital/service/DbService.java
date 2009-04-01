package com.hospital.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hospital.cards.Card;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;

public class DbService {

	public static List<Card> getÑardsByParams(Patient patient,
			HealthWorker healthWorker, Department department) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("patient", patient, params);
		addNotNullParam("healthWorker", healthWorker, params);
		addNotNullParam("department", department, params);

		return daoManager.getInstance(Card.class, params);
	}

	public static List<Card> getÑardsByDepartment(Department department) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("department", department, params);

		return daoManager.getInstance(Card.class, params);
	}

	public static List<Card> getÑardsByHealthWorker(HealthWorker healthWorker) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("healthWorker", healthWorker, params);

		return daoManager.getInstance(Card.class, params);
	}

	public static List<Card> getÑardsByPatient(Patient patient) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("patient", patient, params);

		return daoManager.getInstance(Card.class, params);
	}

	public static List<Card> getÑardsByDate(Date start, Date end) {

		DaoManager<Card> daoManager = new DaoManager<Card>();

		List<Param> params = new ArrayList<Param>();

		addNotNullParam("start", start, params);
		addNotNullParam("end", end, params);

		return daoManager.getInstance(Card.class, params);
	}

	public static List<HealthWorker> getHealthWorkersByName(String firstName,
			String lastName, String middleName) {

		DaoManager<HealthWorker> daoManager = new DaoManager<HealthWorker>();

		List<Param> params = getListParamsByName(firstName, lastName,
				middleName);

		return daoManager.getInstance(HealthWorker.class, params);
	}

	public static List<Patient> getPatientsByName(String firstName,
			String lastName, String middleName) {

		DaoManager<Patient> daoManager = new DaoManager<Patient>();

		List<Param> params = getListParamsByName(firstName, lastName,
				middleName);

		return daoManager.getInstance(Patient.class, params);
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
