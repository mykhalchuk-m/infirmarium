/**
 * 
 */
package com.infirmarium.core.persistance.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.infirmarium.core.persistance.core.BaseLongDAO;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.Department;
import com.infirmarium.core.persistance.domain.Person;

public class CardDAO extends BaseLongDAO<Card> {

	public Card getByDepartment(Department department) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions.eq(Card.Fields.DEPARTMENT, department));
		return (Card) criteria.list();
	}

	public Card getByDoctor(Person person) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions.eq(Card.Fields.DOCTOR, person));
		return (Card) criteria.list();
	}

	public Card getByPatient(Person person) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions.eq(Card.Fields.PATIENT, person));
		return (Card) criteria.list();
	}

	public Card getStartedWithinRange(Date startDate, Date endDate) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions
				.between(Card.Fields.START, startDate, endDate));
		return (Card) criteria.list();
	}

}
