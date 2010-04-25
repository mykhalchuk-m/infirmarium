package com.infirmarium.core.services;

import com.infirmarium.core.persistance.dao.DepartmentDAO;
import com.infirmarium.core.persistance.domain.Department;
import com.infirmarium.core.services.core.IBaseService;

public interface IDepartmentService extends
		IBaseService<Department, DepartmentDAO> {

}
