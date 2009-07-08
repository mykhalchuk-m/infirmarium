package web.admin;

import java.awt.image.DataBufferShort;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hospital.hr.HealthWorker;
import com.hospital.hr.Role;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateHealthWorker extends ActionSupport implements
		ModelDriven<HealthWorker> {

	private static final long serialVersionUID = -185035781814567781L;

	private HealthWorker hw = new HealthWorker();
	private String roleString;
	private String result;

	public String execute() throws Exception {

		hw.setRole(Role.valueOf(getRoleString()));

		DaoManager<HealthWorker> dao = new DaoManager<HealthWorker>();

		List<Param> params = new ArrayList<Param>();
		Param paramId = new Param();
		paramId.setParamName("id");
		paramId.setParamValue(hw.getId());
		params.add(paramId);

		HealthWorker updatedHw = dao.getInstance(HealthWorker.class, params)
				.get(0);

		if (isDuplicationLogin(updatedHw.getLogin(), hw.getLogin())) {
			dao.close();
			return INPUT;
		}

		updatedHw.setFirstName(hw.getFirstName());
		updatedHw.setLastName(hw.getLastName());
		updatedHw.setMiddleName(hw.getMiddleName());
		updatedHw.setSpeciality(hw.getSpeciality());
		updatedHw.setLogin(hw.getLogin());
		updatedHw.setPassword(hw.getPassword());
		updatedHw.setRole(hw.getRole());

		dao.updateInstance(updatedHw);

		dao.close();

		result = "зміни збережено в базу мед.працівників";
		return SUCCESS;
	}

	public void validate() {

		if (hw.getFirstName().length() == 0) {
			addFieldError("firstName", "firstName");
		}
		if (hw.getLastName().length() == 0) {
			addFieldError("lastName", "lastName");
		}
		if (hw.getMiddleName().length() == 0) {
			addFieldError("middleName", "middleName");
		}
		if (hw.getLogin().length() == 0) {
			addFieldError("login", "login");
		}
		if (hw.getPassword().length() == 0) {
			addFieldError("password", "password");
		}
		if (hw.getSpeciality().length() == 0) {
			addFieldError("speciality", "Speciality");
		}

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

	private boolean isDuplicationLogin(String oldLogin, String newLogin) {
		if (oldLogin.equals(newLogin)) {
			return false;
		}
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
			return true;
		} else {
			return false;
		}
	}

}
