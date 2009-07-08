package web.admin;

import java.util.List;

import com.hospital.modulecreator.Module;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;

public class ViewModules implements Action {

	List<Module> modules;

	public String execute() throws Exception {

		setModules(DbService.getExistModules());

		return SUCCESS;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
