package web.admin;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.cards.Card;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.manageres.DaoManager;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;

public class AddCard extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3854821343280928294L;
	@SuppressWarnings("unchecked")
	private Map session;
	private long departmentId = -1;
	private long patientId = -1;
	private String result;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		Department department = DbService.getDepartmentById(getDepartmentId());

		Patient patient = DbService.getPatientById(getPatientId());
		Card card = new Card();

		card.setStart(new Date(System.currentTimeMillis()));
		card.setDepartment(department);
		card.setPatient(patient);

		HealthWorker hw = (HealthWorker) session
				.get(Constants.ENTERED_HEALTH_WORKER);
		card.setHealthWorker(hw);

		DaoManager<Card> daoManager = new DaoManager<Card>();
		daoManager.newInstance(card);
		daoManager.close();

		session.put(Constants.CURRENT_VIEW_CARD, card);
		
		result = "нову картку було успішно створено";

		return SUCCESS;
	}

	public void validate() {

		if (getDepartmentId() == -1) {
			addFieldError("departmentId", "виберіть відділення");
		}
		if (getPatientId() == -1) {
			addFieldError("patientId", "виберіть піцієнта");
		}
		if (!isHwInDepartment()) {
			addFieldError("departmentId", "такий працівник відсутній у вибраному відділені");
		}

	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;

	}

	private boolean isHwInDepartment() {
		Department department = DbService.getDepartmentById(getDepartmentId());
		HealthWorker hwSession = (HealthWorker) session
				.get(Constants.ENTERED_HEALTH_WORKER);
		for (Iterator<HealthWorker> iterator = department.getHealthWorkers()
				.iterator(); iterator.hasNext();) {
			HealthWorker hw = iterator.next();
			if (hw.getId() == hwSession.getId()) {
				return true;
			}

		}

		return false;

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
