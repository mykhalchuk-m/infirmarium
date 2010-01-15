package web.security;

import java.util.Map;

import com.hospital.hr.HealthWorker;
import com.hospital.hr.Role;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AdminRoleInterceptor implements Interceptor {

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

		String hwRole = hw.getRole().name();

		if (hwRole.equals(Role.ADMIN.name())) {

			return actionInvocation.invoke();

		} else {

			return Action.LOGIN; // update this!!!

		}

	}
}