package web.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest; 

import org.apache.struts2.interceptor.ServletRequestAware;

import com.hospital.hr.HealthWorker;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.opensymphony.xwork2.Action;

public class DeleteHealthWorker implements Action, ServletRequestAware {

	HttpServletRequest request;

	public String execute() throws Exception {

		String idString = request.getParameter("id");

		if (idString != null && !idString.equals("")) {
			DaoManager<HealthWorker> dao = new DaoManager<HealthWorker>();

			List<Param> listParams = new ArrayList<Param>();

			Param idParam = new Param();
			idParam.setParamName("id");
			idParam.setParamValue(new Long(idString));

			listParams.add(idParam);

			List<HealthWorker> hwList = dao.getInstance(HealthWorker.class,
					listParams);

			Iterator<HealthWorker> iterator = hwList.iterator();
			if (iterator.hasNext()) {
				HealthWorker hw = iterator.next();
				hw.setExist(Boolean.FALSE);// banned
				dao.updateInstance(hw);
			}
//			dao.close();
		}

		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

}
