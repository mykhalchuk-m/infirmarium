package web.admin;

import java.util.ArrayList;
import java.util.List;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.Module;
import com.opensymphony.xwork2.Action;

public class UpdateDepartmentModules implements Action {

	private Long departmentId;
	private Long moduleId;

	public String execute() throws Exception {

		DaoManager<Module> daoModule = new DaoManager<Module>();
		List<Param> paramsMod = new ArrayList<Param>();
		Param paramModId = new Param();
		paramModId.setParamName("id");
		paramModId.setParamValue(moduleId);
		paramsMod.add(paramModId);
		Module module = daoModule.getInstance(Module.class, paramsMod).get(0);
		daoModule.close();

		// department loading
		DaoManager<Department> daoDepartment = new DaoManager<Department>();

		List<Param> paramsDep = new ArrayList<Param>();
		Param paramDepId = new Param();
		paramDepId.setParamName("id");
		paramDepId.setParamValue(departmentId);
		paramsDep.add(paramDepId);

		Department department = daoDepartment.getInstance(Department.class,
				paramsDep).get(0);
		department.addModule(module);
		daoDepartment.updateInstance(department);
		daoDepartment.close();

		return SUCCESS;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

}
