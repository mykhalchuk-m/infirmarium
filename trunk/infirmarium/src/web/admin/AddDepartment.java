package web.admin;

import java.util.Iterator;
import java.util.List;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddDepartment extends ActionSupport implements
		ModelDriven<Department> {

	private static final long serialVersionUID = 1897582043602622748L;

	private Department department = new Department();
	private String result;

	public String execute() throws Exception {

		DaoManager<Department> dao = new DaoManager<Department>();
		dao.newInstance(department);
		dao.close();

		result = "Відділення \"" + department.getName() + "\""
				+ " було успішно додано";
		return SUCCESS;
	}

	public void validate() {

		if (department.getName().length() == 0) {
			addFieldError("department.name", "введіть назву відділення");
		} else {
			checkDuplicationLogin();
		}

	}

	private void checkDuplicationLogin() {
		List<String> names = DbService.getDepartmentsNames();
		for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
			String depName = iterator.next();
			if (depName.equalsIgnoreCase(department.getName())) {
				addActionError("таке відділення вже існує");
			}

		}
	}

	public Department getModel() {

		return department;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
