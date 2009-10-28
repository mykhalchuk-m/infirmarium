package web.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.AbstractModule;
import com.hospital.modulecreator.Module;
import com.opensymphony.xwork2.Action;

public class DeleteModule implements Action, ServletRequestAware {

	HttpServletRequest request;

	public String execute() throws Exception {

		String idString = request.getParameter("id");

		if (idString != null && !idString.equals("")) {
			DaoManager<AbstractModule> dao = new DaoManager<AbstractModule>();

			List<Param> listParams = new ArrayList<Param>();

			Param idParam = new Param();
			idParam.setParamName("id");
			idParam.setParamValue(new Long(idString));

			listParams.add(idParam);

			List<AbstractModule> hwList = dao.getInstance(AbstractModule.class,
					listParams);

			Iterator<AbstractModule> iterator = hwList.iterator();
			if (iterator.hasNext()) {
				AbstractModule module = iterator.next();
				module.setExist(Boolean.FALSE);// banned
				dao.updateInstance(module);
			}
//			dao.close();
		}

		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

}
