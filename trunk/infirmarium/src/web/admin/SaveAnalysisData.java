package web.admin;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.cards.Card;
import com.hospital.manageres.DaoManager;
import com.hospital.module.AnalysisData;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SaveAnalysisData extends ActionSupport implements SessionAware, Action {

	private static final long serialVersionUID = 5848878694822843392L;

	@SuppressWarnings("unchecked")
	private Map session;
	private AnalysisData analysisData;
	private long abstractModuleId;
	private String result;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		analysisData.setCreationDate(new Date(System.currentTimeMillis()));
		analysisData.setAbstractModule(DbService.getAnalysisById(getAbstractModuleId()));
		
		Card card = (Card) session.get(Constants.CURRENT_VIEW_CARD);
		card.addAnalysesData(analysisData);

		DaoManager<Card> daoManager = new DaoManager<Card>();
		daoManager.updateInstance(card);
		daoManager.close();

		session.put(Constants.CURRENT_VIEW_CARD, card);

		setResult("Аналіз занесено в медичну карту");
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public AnalysisData getAnalysisData() {
		return analysisData;
	}

	public void setAnalysisData(AnalysisData analysisData) {
		this.analysisData = analysisData;
	}

	public long getAbstractModuleId() {
		return abstractModuleId;
	}

	public void setAbstractModuleId(long abstractModuleId) {
		this.abstractModuleId = abstractModuleId;
	}

	

}
