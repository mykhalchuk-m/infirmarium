package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.ModuleDefDAO;
import com.infirmarium.core.persistance.domain.module.ModuleDef;

public interface IModuleDefService extends
		IBaseService<ModuleDef, ModuleDefDAO> {

}
