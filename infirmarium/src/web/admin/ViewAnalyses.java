package web.admin;

import java.util.List;

import com.hospital.modulecreator.Analysis;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;

public class ViewAnalyses implements Action {

	List<Analysis> analyses;

	public String execute() throws Exception {

		setAnalyses(DbService.getExistAnalyses());

		return SUCCESS;
	}

	public List<Analysis> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(List<Analysis> analyses) {
		this.analyses = analyses;
	}

}
