package com.infirmarium.core.services;

import com.infirmarium.core.persistance.dao.ModuleValueDAO;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;
import com.infirmarium.core.services.core.IBaseService;

public interface IModuleValueService extends
		IBaseService<ModuleValue, ModuleValueDAO> {

	public FieldValue getByCard(Card card);

}
