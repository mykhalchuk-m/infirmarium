package com.infirmarium.core.services.impl;

import com.infirmarium.core.persistance.core.BaseServiceImpl;
import com.infirmarium.core.persistance.dao.FieldValueDAO;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;
import com.infirmarium.core.services.IFieldValueService;

public class FieldValueServiceImpl extends
		BaseServiceImpl<FieldValue, FieldValueDAO> implements
		IFieldValueService {

	@Override
	public FieldValue getByModuleValue(ModuleValue moduleValue) {
		// TODO add exeptions handling
		return getDao().getByModuleValue(moduleValue);
	}

}
