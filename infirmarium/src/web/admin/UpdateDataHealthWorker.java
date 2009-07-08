package web.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.hospital.hr.HealthWorker;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.opensymphony.xwork2.Action;

public class UpdateDataHealthWorker implements Action  {

	private HealthWorker hwData;
	private Long hwId;


	public String execute() throws Exception {


		DaoManager<HealthWorker> dao = new DaoManager<HealthWorker>();
		List<Param> params = new ArrayList<Param>();
		Param paramId = new Param();
		paramId.setParamName("id");
		paramId.setParamValue(getHwId());
		params.add(paramId);
		HealthWorker hw = dao.getInstance(HealthWorker.class, params).get(0);
		setHwData(hw);
		dao.close();
		

		return SUCCESS;
	}

	

	public HealthWorker getHwData() {
		return hwData;
	}

	public void setHwData(HealthWorker hwData) {
		this.hwData = hwData;
	}



	public Long getHwId() {
		return hwId;
	}



	public void setHwId(Long hwId) {
		this.hwId = hwId;
	}



}
