package web.admin;

import java.util.List;

import com.hospital.hr.Patient;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;

public class ViewPatients implements Action {

	List<Patient> patients;

	public String execute() throws Exception {

		setPatients(DbService.getPatients());

		return SUCCESS;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
