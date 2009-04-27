package web.common;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.hr.HealthWorker;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5909266645039284582L;

	private String login;
	private String password;
	@SuppressWarnings( { "unchecked", "unused" })
	private Map session;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		HealthWorker hw = DbService.getRegisteredHealthWorker(login, password);

		if (hw != null) {
			session.put(Constants.ENTERED_HEALTH_WORKER, hw);
			return SUCCESS;
		}else {
			addActionError(getText("wrong.data"));
			return INPUT;
		}
		
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;

	}

	public void validate() {

		if (login.length() == 0) {
			addFieldError("login", getText("login.required"));
		}

		if (password.length() == 0) {
			addFieldError("password", getText("password.required"));
		}

	}

}
