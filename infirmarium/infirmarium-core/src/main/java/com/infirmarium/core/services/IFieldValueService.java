package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.FieldValueDAO;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;

public interface IFieldValueService extends
		IBaseService<FieldValue, FieldValueDAO> {
	public FieldValue getByModuleValue(ModuleValue moduleValue);
}
