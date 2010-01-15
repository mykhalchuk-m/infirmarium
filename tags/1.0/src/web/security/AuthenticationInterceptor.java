package web.security;

import java.util.Map;

import com.hospital.hr.HealthWorker;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
	}

	public void init() {
	}

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation actionInvocation) throws Exception {

		Map session = actionInvocation.getInvocationContext().getSession();
		HealthWorker hw = (HealthWorker) session
				.get(Constants.ENTERED_HEALTH_WORKER);

		if (hw == null) {
			return Action.LOGIN;
		} else {
			return actionInvocation.invoke();
		}
	}
}