package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.ModuleValueDAO;
import com.infirmarium.core.persistance.domain.module.ModuleValue;

public interface IModuleValueService extends
		IBaseService<ModuleValue, ModuleValueDAO> {

}
