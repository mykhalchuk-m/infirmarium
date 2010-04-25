package com.infirmarium.core.services;

import com.infirmarium.core.persistance.dao.PersonDAO;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.services.core.IBaseService;

public interface IPersonService extends IBaseService<Person, PersonDAO> {

}
