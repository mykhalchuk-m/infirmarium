package web.admin;

import java.util.ArrayList;
import java.util.List;

import com.hospital.cards.Card;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.opensymphony.xwork2.Action;

public class ViewCards implements Action {

	List<Card> cards;

	public String execute() throws Exception {

		DaoManager<Card> dao = new DaoManager<Card>();

		List<Card> cardsDao = dao.getInstance(Card.class,
				new ArrayList<Param>());
		setCards(cardsDao);

//		dao.close();
		return SUCCESS;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
