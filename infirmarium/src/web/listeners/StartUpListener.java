package web.listeners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hospital.hr.BloodGroup;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Role;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.service.DbService;

public class StartUpListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {

		HealthWorker hw = cheackAdmin("admin");
		if (hw == null) {
			createBloodGrup();
			createDefaultDepartment();
		}
	}

	private void createBloodGrup() {
		String[] groups = { "I +", "I -", "II +", "II -", "III +", "III -",
				"IV +", "IV -" };
		DaoManager<BloodGroup> bloodDao = new DaoManager<BloodGroup>();
		for (String group : groups) {
			BloodGroup bg = new BloodGroup();
			bg.setBloodGroupValue(group);
			bloodDao.newInstance(bg);
		}
	}

	private HealthWorker cheackAdmin(String login) {

		DaoManager<HealthWorker> daoManager = new DaoManager<HealthWorker>();

		List<Param> params = new ArrayList<Param>();

		Param loginParam = new Param();
		loginParam.setParamName("login");
		loginParam.setParamValue(login);
		params.add(loginParam);

		List<HealthWorker> healthWorkers = daoManager.getInstance(
				HealthWorker.class, params);

		daoManager.close();

		Iterator<HealthWorker> iterator = healthWorkers.iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}
	}

	private void createDefaultDepartment() {
		Department administration = new Department();
		String name = "administration";
		administration.setName(name);
		DaoManager<Department> daoManager = new DaoManager<Department>();
		daoManager.newInstance(administration);
		createAdminHealthWorker(name);
	}

	private void createAdminHealthWorker(String departmentName) {
		HealthWorker newHW = new HealthWorker();
		newHW.setFirstName("admin");
		newHW.setLastName("admin");
		newHW.setLogin("admin");
		newHW.setPassword("admin");
		newHW.setRole(Role.ADMIN);
		newHW.setSpeciality("admin");
		newHW.setExist(true);
		Department department = DbService.getDepartmentByName(departmentName);
		DaoManager<Department> dao = new DaoManager<Department>();
		department.addHealthWorker(newHW);
		dao.updateInstance(department);
	}
}
