package test.menu.items;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hospital.cards.Card;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.hr.SexTypes;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.module.AnalysisData;
import com.hospital.module.ModuleData;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.FieldTypes;

public class CreatorCard implements MenuItem {

	private String name = "card";

	public String getName() {
		return name;
	}

	public void executeItem() {
		Scanner scanner = new Scanner(System.in);
		Card card = new Card();
		card.setStart(new Date(System.currentTimeMillis() - 3600 * 24 * 50));
		card.setEnd(new Date(System.currentTimeMillis()));

		DaoManager<Department> depMan = new DaoManager<Department>();
		List<Department> deps = depMan.getInstance(Department.class,
				new ArrayList<Param>());

		for (ListIterator<Department> iterator = deps.listIterator(); iterator
				.hasNext();) {
			Department department = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ department.getName());
		}
		System.out.println("Виберіть відділення: ");
		Department department = deps.get(Integer.parseInt(scanner.nextLine()));
		card.setDepartment(department);

		// ----------------------------------------------------

		DaoManager<Patient> patMan = new DaoManager<Patient>();
		List<Patient> pats = patMan.getInstance(Patient.class,
				new ArrayList<Param>());

		for (ListIterator<Patient> iterator = pats.listIterator(); iterator
				.hasNext();) {
			Patient patient = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ patient.getFirstName() + " " + patient.getLastName());
		}
		System.out.println("Виберіть пацієнта: ");
		card.setPatient(pats.get(Integer.parseInt(scanner.nextLine())));

		// ----------------------------------------------------

		// DaoManager<HealthWorker> hwMan = new DaoManager<HealthWorker>();
		List<HealthWorker> hws = new LinkedList<HealthWorker>(department
				.getHealthWorkers());

		for (ListIterator<HealthWorker> iterator = hws.listIterator(); iterator
				.hasNext();) {
			HealthWorker healthWorker = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ healthWorker.getFirstName() + "  "
					+ healthWorker.getLastName());
		}
		System.out.println("Виберіть лікаря: ");
		card.setHealthWorker(hws.get(Integer.parseInt(scanner.nextLine())));

		// ----------------------------------------------------
		System.out.println("заповнити модулі: (y/n) ");
		if (scanner.nextLine().equalsIgnoreCase("y")) {
			// DaoManager<Module> modMan = new DaoManager<Module>();
			List<Module> mods = new LinkedList<Module>(department.getModules());

			do {
				ModuleData moduleData = new ModuleData();
				for (ListIterator<Module> iterator = mods.listIterator(); iterator
						.hasNext();) {
					Module module = iterator.next();
					System.out.println((iterator.nextIndex() - 1) + ". "
							+ module.getModuleName());
				}
				System.out.print("Виберіть модуль, який хочете заповнити: ");
				Module module = mods.get(Integer.parseInt(scanner.nextLine()));
				moduleData.setName(module.getModuleName());
				moduleData.setAbstractModule(module);
				Map<String, String> data = new HashMap<String, String>();

				do {
					Set<String> paramNames = module.getParameters().keySet();
					List<String> names = new LinkedList<String>(paramNames);
					for (ListIterator<String> iterator = names.listIterator(); iterator
							.hasNext();) {
						String name = iterator.next();
						System.out.println((iterator.nextIndex() - 1) + ". "
								+ name);
					}
					System.out.print("виберіть параметр: ");
					String paramName = names.get(Integer.parseInt(scanner
							.nextLine()));
					String type = module.getParameter(paramName).getType()
							.name();

					if (type.equals(FieldTypes.SELECTBOX.name())) {
						List<String> paramVal = module.getParameter(paramName)
								.getValues();
						List<String> values = new LinkedList<String>(paramVal);

						for (ListIterator<String> iterator2 = values
								.listIterator(); iterator2.hasNext();) {
							String value = iterator2.next();
							System.out.println((iterator2.nextIndex() - 1)
									+ ". " + value);
						}
						System.out.print("виберіть значення: ");
						data.put(paramName, values.get(Integer.parseInt(scanner
								.nextLine())));
					} else if (type.equals(FieldTypes.TEXTBOX.name())) {
						System.out.print("введіть значення: ");
						data.put(paramName, scanner.nextLine());
					}
					System.out.print("ще параметри <x> - exit: ");
				} while (!scanner.nextLine().equals("x"));
				moduleData.setParameters(data);
				card.addModuleData(moduleData);
				System.out.print("ще модулі <x> - exit: ");
			} while (!scanner.nextLine().equals("x"));

		}
		// -----------------------------------------------------

		System.out.println("заповнити analysis: (y/n) ");
		if (scanner.nextLine().equalsIgnoreCase("y")) {
			List<Analysis> analyses = new LinkedList<Analysis>(department
					.getAnalyses());

			do {
				AnalysisData analysisData = new AnalysisData();
				for (ListIterator<Analysis> iterator = analyses.listIterator(); iterator
						.hasNext();) {
					Analysis analysis = iterator.next();
					System.out.println((iterator.nextIndex() - 1) + ". "
							+ analysis.getModuleName());
				}
				System.out.print("Виберіть analysis, який хочете заповнити: ");
				Analysis analysis = analyses.get(Integer.parseInt(scanner
						.nextLine()));
				analysisData.setName(analysis.getModuleName());
				analysisData.setAbstractModule(analysis);

				do {
					Set<String> paramNames = analysis.getParameters().keySet();
					List<String> names = new LinkedList<String>(paramNames);
					for (ListIterator<String> iterator = names.listIterator(); iterator
							.hasNext();) {
						String name = iterator.next();
						System.out.println((iterator.nextIndex() - 1) + ". "
								+ name);
					}
					System.out.print("виберіть параметр: ");
					String paramName = names.get(Integer.parseInt(scanner
							.nextLine()));

					String type = analysis.getParameter(paramName).getType()
							.name();

					if (type.equals(FieldTypes.SELECTBOX.name())) {
						List<String> paramVal = analysis
								.getParameter(paramName).getValues();
						List<String> values = new LinkedList<String>(paramVal);

						for (ListIterator<String> iterator2 = values
								.listIterator(); iterator2.hasNext();) {
							String value = iterator2.next();
							System.out.println((iterator2.nextIndex() - 1)
									+ ". " + value);
						}
						System.out.print("виберіть значення: ");
						analysisData.addParameter(paramName, values.get(Integer
								.parseInt(scanner.nextLine())));

					} else if (type.equals(FieldTypes.TEXTBOX.name())) {
						System.out.print("введіть значення: ");
						analysisData
								.addParameter(paramName, scanner.nextLine());
					} else if (type.equals(FieldTypes.NORM.name())) {
						Field field = analysis.getParameter(paramName);
						System.out.println("Norm = " + field.getNorm());
						System.out.print("введіть значення:    ("
								+ field.getNorm().getMinValue() + " - "
								+ field.getNorm().getMaxValue() + ") "
								+ field.getNorm().getUnit() + ": ");
						analysisData.addParameter(paramName, Double
								.valueOf(scanner.nextLine()));
					} else if (type.equals(FieldTypes.SEX_NORM.name())) {
						Field field = analysis.getParameter(paramName);
						System.out.println("SexNorm = " + field.getSexNorm());

						String sex = card.getPatient().getSex().name();
						if (sex.equals(SexTypes.MALE.name())) {
							System.out.print("введіть значення:    ("
									+ field.getSexNorm().getMinMaleValue()
									+ " - "
									+ field.getSexNorm().getMaxMaleValue()
									+ ") " + field.getSexNorm().getUnit()
									+ ": ");
						} else if (sex.equals(SexTypes.FEMALE.name())) {
							System.out.print("введіть значення:    ("
									+ field.getSexNorm().getMinFemaleValue()
									+ " - "
									+ field.getSexNorm().getMaxFemaleValue()
									+ ") " + field.getSexNorm().getUnit()
									+ ": ");
						}
						analysisData.addParameter(paramName, Double
								.valueOf(scanner.nextLine()));
					}
					System.out.print("ще параметри <x> - exit: ");
				} while (!scanner.nextLine().equals("x"));

				card.addAnalysesData(analysisData);
				System.out.print("ще analysis <x> - exit: ");
			} while (!scanner.nextLine().equals("x"));

			// -----------------------------------------------------
		}
		new DaoManager<Card>().newInstance(card);

	}
}
