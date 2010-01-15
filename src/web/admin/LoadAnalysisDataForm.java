package web.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.cards.Card;
import com.hospital.hr.HealthWorker;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoadAnalysisDataForm extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5848878694822843392L;

	@SuppressWarnings("unchecked")
	private Map session;
	private int analysisId = -1;
	private Analysis formAnalysis;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		Analysis analysis = DbService.getAnalysisById(getAnalysisId());
		setFormAnalysis(analysis);

		return SUCCESS;
	}

	public void validate() {

		if (getAnalysisId() == -1) {
			addFieldError("moduleId", "виберіть аналіз");
		} else if (!isHwCreatorCard()) {
			addFieldError("moduleId",
					"заповнити аналіз може тільки мед.працівник, що створив медичну катру");
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

	

	

	public int getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(int analysisId) {
		this.analysisId = analysisId;
	}

	public Analysis getFormAnalysis() {
		return formAnalysis;
	}

	public void setFormAnalysis(Analysis formAnalysis) {
		this.formAnalysis = formAnalysis;
	}

}
