package web.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;

public class ViewHealthWorkers implements Action {

	List<HealthWorker> healthWorkers;

	public String execute() throws Exception {

		setHealthWorkers(DbService.getExistHealthWorkers());

		return SUCCESS;
	}

	public List<HealthWorker> getHealthWorkers() {
		return healthWorkers;
	}

	public void setHealthWorkers(List<HealthWorker> healthWorkers) {
		this.healthWorkers = healthWorkers;
	}

}
