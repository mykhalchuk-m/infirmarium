package web.admin;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.cards.Card;
import com.hospital.manageres.DaoManager;
import com.hospital.module.ModuleData;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SaveModuleData extends ActionSupport implements SessionAware,
		Action {

	private static final long serialVersionUID = 5848878694822843392L;

	@SuppressWarnings("unchecked")
	private Map session;
	private ModuleData moduleData;
	private long abstractModuleId;
	private String result;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		moduleData.setCreationDate(new Date(System.currentTimeMillis()));

		moduleData.setAbstractModule(DbService
				.getModuleById(getAbstractModuleId()));

		Card card = (Card) session.get(Constants.CURRENT_VIEW_CARD);

		card.addModuleData(moduleData);

		DaoManager<Card> daoManager = new DaoManager<Card>();

		daoManager.updateInstance(card);

		daoManager.close();

		session.put(Constants.CURRENT_VIEW_CARD, card);

		setResult("форма була успішно додана");
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

	public ModuleData getModuleData() {
		return moduleData;
	}

	public void setModuleData(ModuleData moduleData) {
		this.moduleData = moduleData;
	}

	public long getAbstractModuleId() {
		return abstractModuleId;
	}

	public void setAbstractModuleId(long abstractModuleId) {
		this.abstractModuleId = abstractModuleId;
	}

}
