package com.infirmarium.core.services.impl;

import com.infirmarium.core.persistance.dao.AddressDAO;
import com.infirmarium.core.persistance.domain.Address;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.services.IAddressService;
import com.infirmarium.core.services.core.BaseServiceImpl;

public class AddressServiceImpl extends BaseServiceImpl<Address, AddressDAO>
		implements IAddressService {

	@Override
	public Address getByPerson(Person person) {
		// TODO add exeptions handling
		return getDao().getByPerson(person);
	}

}
