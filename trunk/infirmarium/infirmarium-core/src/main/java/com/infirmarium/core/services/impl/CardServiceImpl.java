package com.infirmarium.core.services.impl;

import java.util.Date;

import com.infirmarium.core.persistance.core.BaseServiceImpl;
import com.infirmarium.core.persistance.dao.CardDAO;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.Department;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.services.ICardService;

public class CardServiceImpl extends BaseServiceImpl<Card, CardDAO> implements
		ICardService {

	@Override
	public Card getByDepartment(Department department) {
		// TODO add exeptions handling
		return getDao().getByDepartment(department);
	}

	@Override
	public Card getByDoctor(Person doctor) {
		// TODO add exeptions handling
		return getDao().getByDoctor(doctor);
	}

	@Override
	public Card getByPatient(Person patient) {
		// TODO add exeptions handling
		return getDao().getByPatient(patient);
	}

	@Override
	public Card getStartedWithinRange(Date startDate, Date endDate) {
		// TODO add exeptions handling
		return getDao().getStartedWithinRange(startDate, endDate);
	}
}
