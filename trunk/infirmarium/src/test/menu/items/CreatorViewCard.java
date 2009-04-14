package test.menu.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import com.hospital.cards.Card;
import com.hospital.hr.SexTypes;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.module.AnalysisData;
import com.hospital.module.ModuleData;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.FieldTypes;

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

		System.out.println("Виберіть карточку пацієнта: ");
		Card selectedCard = cards.get(Integer.parseInt(scanner.nextLine()));

		List<ModuleData> modelesData = selectedCard.getModulesData();

		for (Iterator<ModuleData> iterator = modelesData.iterator(); iterator
				.hasNext();) {
			ModuleData moduleData = (ModuleData) iterator.next();

			System.out.println();
			System.out.println("----->>>>  Імя модуля : <" + moduleData.getName()
					+ "> був створений " + moduleData.getCreationDate());

			Map<String, String> mapParams = moduleData.getParameters();
			for (Iterator<String> iterator2 = mapParams.keySet().iterator(); iterator2
					.hasNext();) {
				String key = iterator2.next();

				System.out.println(" ----->>>>         параметр  <" + key + ">  =  "
						+ mapParams.get(key));

			}
		}

		// ////////////////analysis///////////
		List<AnalysisData> analysesData = selectedCard.getAnalysesData();

		for (Iterator<AnalysisData> iterator = analysesData.iterator(); iterator
				.hasNext();) {
			AnalysisData analysisData = (AnalysisData) iterator.next();

			System.out.println();
			System.out.println("----->>>>  Імя аналіза : <" + analysisData.getName()
					+ "> був створений " + analysisData.getCreationDate()+"  size="+analysesData.size());
			
			Map<String, String> mapParams2 = analysisData.getParameters();
			for (Iterator<String> iterator2 = mapParams2.keySet().iterator(); iterator2
					.hasNext();) {
				String key = iterator2.next();

				System.out.println(" ----->>>>         параметр  <" + key + ">  =  "
						+ mapParams2.get(key));

			}
			

			Map<String, Double> mapParams = analysisData.getNormParameters();

			for (Iterator<String> iterator2 = mapParams.keySet().iterator(); iterator2
					.hasNext();) {
				String key = iterator2.next();

				Field record = analysisData.getFieldByParamName(key);

				System.out.print("----->>>>          параметр  <" + key + ">  =  "
						+ mapParams.get(key));

				if (record.getType().equals(FieldTypes.NORM)) {
					System.out.print("----->>>>    норма ("
							+ record.getNorm().getMinValue() + " - "
							+ record.getNorm().getMaxValue() + ") "
							+ record.getNorm().getUnit());
				}

				if (record.getType().equals(FieldTypes.SEX_NORM)) {

					if (selectedCard.getPatient().getSex()
							.equals(SexTypes.MALE)) {
						System.out.print("----->>>>    норма MALE ("
								+ record.getSexNorm().getMinMaleValue() + " - "
								+ record.getSexNorm().getMaxMaleValue() + ") "
								+ record.getSexNorm().getUnit());

					} else {
						System.out.print("----->>>>   норма FEMALE("
								+ record.getSexNorm().getMinFemaleValue()
								+ " - "
								+ record.getSexNorm().getMaxFemaleValue()
								+ ") " + record.getSexNorm().getUnit());
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
}
