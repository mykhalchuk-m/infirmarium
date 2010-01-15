package web.admin;

import java.util.ArrayList;
import java.util.List;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.Analysis;
import com.opensymphony.xwork2.Action;

public class UpdateDepartmentAnalyses implements Action {

	private Long departmentId;
	private Long analysisId;

	private String result;

	public String execute() throws Exception {

		DaoManager<Analysis> daoAnalysis = new DaoManager<Analysis>();
		List<Param> paramsAn = new ArrayList<Param>();
		Param paramAnId = new Param();
		paramAnId.setParamName("id");
		paramAnId.setParamValue(analysisId);
		paramsAn.add(paramAnId);
		Analysis analysis = daoAnalysis.getInstance(Analysis.class, paramsAn)
				.get(0);
//		daoAnalysis.close();

		// department loading
		DaoManager<Department> daoDepartment = new DaoManager<Department>();

		List<Param> paramsDep = new ArrayList<Param>();
		Param paramDepId = new Param();
		paramDepId.setParamName("id");
		paramDepId.setParamValue(departmentId);
		paramsDep.add(paramDepId);

		Department department = daoDepartment.getInstance(Department.class,
				paramsDep).get(0);
		department.addAnalysis(analysis);
		daoDepartment.updateInstance(department);
//		daoDepartment.close();

		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(Long analysisId) {
		this.analysisId = analysisId;
	}

}
