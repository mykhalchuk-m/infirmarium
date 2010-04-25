package com.infirmarium.core.services;

import com.infirmarium.core.persistance.dao.AddressDAO;
import com.infirmarium.core.persistance.domain.Address;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.services.core.IBaseService;

public interface IAddressService extends IBaseService<Address, AddressDAO> {
	
	public Address getByPerson(Person person);
}
