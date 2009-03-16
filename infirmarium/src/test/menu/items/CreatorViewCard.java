package test.menu.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hospital.cards.Card;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.module.ModuleData;

public class CreatorViewCard implements MenuItem {

	private String name = "view card";

	public String getName() {
		return name;
	}

	public void executeItem() {
		Scanner scanner = new Scanner(System.in);

		DaoManager<Card> cardsDao = new DaoManager<Card>();
		List<Card> cards = cardsDao.getInstance(Card.class,
				new ArrayList<Param>());
		for (ListIterator<Card> iterator = cards.listIterator(); iterator
				.hasNext();) {
			Card card = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + " - crad of  <"
					+ card.getPatient().getFirstName() + " "
					+ card.getPatient().getLastName() + ">");

		}

		System.out.println("������� �������� ��������: ");
		Card selectedCard = cards.get(Integer.parseInt(scanner.nextLine()));

		Set<ModuleData> modelesData = selectedCard.getModulesData();

		for (Iterator<ModuleData> iterator = modelesData.iterator(); iterator
				.hasNext();) {
			ModuleData moduleData = (ModuleData) iterator.next();

			System.out.println();
			System.out.println("��� ������ : <" + moduleData.getName()
					+ "> ��� ��������� " + moduleData.getCreationDate());

			Map<String, String> mapParams = moduleData.getParameters();
			for (Iterator<String> iterator2 = mapParams.keySet().iterator(); iterator2
					.hasNext();) {
				String key = iterator2.next();

				System.out.println("         ��������  <" + key + ">  =  "
						+ mapParams.get(key));

			}
		}
	}

}
