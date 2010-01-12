package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.PersonDAO;
import com.infirmarium.core.persistance.domain.Person;

public interface IPersonService extends IBaseService<Person, PersonDAO> {

}
