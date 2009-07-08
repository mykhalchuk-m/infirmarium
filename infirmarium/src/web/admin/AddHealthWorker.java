package web.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Role;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddHealthWorker extends ActionSupport implements
		ModelDriven<HealthWorker> {

	private static final long serialVersionUID = -185035781814567781L;

	private HealthWorker hw = new HealthWorker();
	private String department;
	private String roleString;
	private String result;

	public String execute() throws Exception {

		hw.setRole(Role.valueOf(getRoleString()));

		Department depart = DbService.getDepartmentByName(getDepartment());

		depart.addHealthWorker(hw);

		DaoManager<Department> dao = new DaoManager<Department>();
		dao.updateInstance(depart);
		dao.close();

		result = "\"" + hw.getFirstName() + " " + hw.getLastName() + "\""
				+ " доданий в базу мед.працівників";
		return SUCCESS;
	}

	public void validate() {

		if (hw.getFirstName().length() == 0) {
			addFieldError("firstName", "введіть імя");
		}
		if (hw.getLastName().length() == 0) {
			addFieldError("lastName", "введіть прізвище");
		}
		if (hw.getMiddleName().length() == 0) {
			addFieldError("middleName", "введіть по-батькові");
		}
		if (hw.getLogin().length() == 0) {
			addFieldError("login", "ввеіть логін");
		} else {
			checkDuplicationLogin();
		}
		if (hw.getPassword().length() == 0) {
			addFieldError("password", "введіть пароль");
		}
		if (hw.getSpeciality().length() == 0) {
			addFieldError("speciality", "введіть спеціальність");
		}

	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public HealthWorker getModel() {

		return hw;
	}

	public String getRoleString() {
		return roleString;
	}

	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private void checkDuplicationLogin() {
		DaoManager<HealthWorker> dao = new DaoManager<HealthWorker>();

		List<Param> listParams = new ArrayList<Param>();

		Param idParam = new Param();
		idParam.setParamName("login");
		idParam.setParamValue(hw.getLogin());

		listParams.add(idParam);

		List<HealthWorker> hwList = dao.getInstance(HealthWorker.class,
				listParams);

		Iterator<HealthWorker> iterator = hwList.iterator();
		if (iterator.hasNext()) {
			addActionError("change login");
		}
	}

}
