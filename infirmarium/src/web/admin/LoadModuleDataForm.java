package web.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.cards.Card;
import com.hospital.hr.HealthWorker;
import com.hospital.modulecreator.Module;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoadModuleDataForm extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5848878694822843392L;

	@SuppressWarnings("unchecked")
	private Map session;
	private int moduleId = -1;
	private Module formModule;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		Module module = DbService.getModuleById(getModuleId());
		setFormModule(module);

		return SUCCESS;
	}

	public void validate() {

		if (getModuleId() == -1) {
			addFieldError("moduleId", "виберіть модуль");
		} else if (!isHwCreatorCard()) {
			addFieldError("moduleId",
					"заповнити модуль може тільки мед.працівник, що створив медичну катру");
		}
	}

	private boolean isHwCreatorCard() {
		Card cardSession = (Card) session.get(Constants.CURRENT_VIEW_CARD);
		HealthWorker creatorCard = cardSession.getHealthWorker();

		HealthWorker loggedHw = (HealthWorker) session
				.get(Constants.ENTERED_HEALTH_WORKER);

		if (loggedHw.getId() == creatorCard.getId()) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;

	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public Module getFormModule() {
		return formModule;
	}

	public void setFormModule(Module formModule) {
		this.formModule = formModule;
	}

}
