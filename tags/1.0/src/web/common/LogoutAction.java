package web.common;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -764567118589565058L;
	@SuppressWarnings("unchecked")
	private Map session;

	@SuppressWarnings("unchecked")
	public String execute() {
		if (session.get(Constants.ENTERED_HEALTH_WORKER) != null) {
			session.put(Constants.ENTERED_HEALTH_WORKER, null);
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;
	}

}
