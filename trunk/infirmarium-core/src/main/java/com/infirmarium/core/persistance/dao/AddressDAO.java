package com.infirmarium.core.persistance.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.infirmarium.core.persistance.dao.core.BaseLongDAO;
import com.infirmarium.core.persistance.domain.Address;
import com.infirmarium.core.persistance.domain.Person;

public class AddressDAO extends BaseLongDAO<Address> {

	public Address getByPerson(Person person) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions.eq(Address.Fields.OWNERS, person));
		return (Address) criteria.list();
	}

}
