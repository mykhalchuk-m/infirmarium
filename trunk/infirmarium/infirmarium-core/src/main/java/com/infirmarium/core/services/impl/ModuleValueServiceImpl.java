package com.infirmarium.core.services.impl;

import com.infirmarium.core.persistance.core.BaseServiceImpl;
import com.infirmarium.core.persistance.dao.ModuleValueDAO;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;
import com.infirmarium.core.services.IModuleValueService;

public class ModuleValueServiceImpl extends
		BaseServiceImpl<ModuleValue, ModuleValueDAO> implements
		IModuleValueService {

	@Override
	public FieldValue getByCard(Card card) {
		// TODO add exeptions handling
		return getDao().getByCard(card);
	}

}
