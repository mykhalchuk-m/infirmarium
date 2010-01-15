package web.admin;

import java.util.List;

import com.hospital.hr.Department;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;

public class ViewDepartments implements Action {

	List<Department> departments;

	public String execute() throws Exception {

		setDepartments(DbService.getDepartments());

		return SUCCESS;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

}
