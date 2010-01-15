package web.admin;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import web.security.Constants;

import com.hospital.cards.Card;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;

public class CardExplorer implements SessionAware, Action {

	@SuppressWarnings("unchecked")
	private Map session;
	private int cardId = -1;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		Card cardSession = (Card) session.get(Constants.CURRENT_VIEW_CARD);

		if ((getCardId() == -1)) {

			if (cardSession == null) {
				return NONE;
			} else {
				return SUCCESS;
			}

		} else {

			Card card = DbService.getCardById(getCardId());
			session.put(Constants.CURRENT_VIEW_CARD, card);

			return SUCCESS;
		}
	}

	@SuppressWarnings("unchecked")
	public void setSession(Map session) {
		this.session = session;

	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

}
