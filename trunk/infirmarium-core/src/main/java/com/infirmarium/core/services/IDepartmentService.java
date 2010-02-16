package com.infirmarium.core.services;

import com.infirmarium.core.persistance.core.IBaseService;
import com.infirmarium.core.persistance.dao.DepartmentDAO;
import com.infirmarium.core.persistance.domain.Department;

public interface IDepartmentService extends
		IBaseService<Department, DepartmentDAO> {

}
