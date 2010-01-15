package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.FieldValueDAO;
import com.infirmarium.core.persistance.domain.field.FieldValue;

public interface IFieldValueService extends
		IBaseService<FieldValue, FieldValueDAO> {

}
