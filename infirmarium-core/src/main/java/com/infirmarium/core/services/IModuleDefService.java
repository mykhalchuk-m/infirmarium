package com.infirmarium.core.services;

import com.infirmarium.core.persistance.dao.ModuleDefDAO;
import com.infirmarium.core.persistance.domain.module.ModuleDef;
import com.infirmarium.core.services.core.IBaseService;

public interface IModuleDefService extends
		IBaseService<ModuleDef, ModuleDefDAO> {

}
