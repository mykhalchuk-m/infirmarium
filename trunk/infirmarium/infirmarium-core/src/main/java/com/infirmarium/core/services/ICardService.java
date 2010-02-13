package com.infirmarium.core.services;

import java.util.Date;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.CardDAO;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.Department;
import com.infirmarium.core.persistance.domain.Person;

public interface ICardService extends IBaseService<Card, CardDAO> {

	public Card getByDoctor(Person person);

	public Card getByPatient(Person personId);

	public Card getByDepartment(Department department);

	public Card getStartedWithinRange(Date startDate, Date endDate);
}
