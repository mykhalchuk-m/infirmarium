package com.infirmarium.core.services;

import com.infirmarium.core.persistance.dao.FieldValueDAO;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;
import com.infirmarium.core.services.core.IBaseService;

public interface IFieldValueService extends
		IBaseService<FieldValue, FieldValueDAO> {
	public FieldValue getByModuleValue(ModuleValue moduleValue);
}
