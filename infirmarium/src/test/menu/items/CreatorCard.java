package test.menu.items;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.hospital.module.ModuleData;
import com.hospital.modulecreator.FieldTypes;
import com.hospital.modulecreator.Module;

public class CreatorCard implements MenuItem {

	private String name = "card";

	public String getName() {
		return name;
	}

	public void executeItem() {
		Scanner scanner = new Scanner(System.in);
		Card card = new Card();
		card.setStart(new Date(System.currentTimeMillis()));

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
		
//		DaoManager<HealthWorker> hwMan = new DaoManager<HealthWorker>();
		List<HealthWorker> hws = new LinkedList<HealthWorker>(department.getHealthWorkers());

		for (ListIterator<HealthWorker> iterator = hws.listIterator(); iterator
				.hasNext();) {
			HealthWorker healthWorker = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ healthWorker.getFirstName() + "  "
					+ healthWorker.getLastName());
		}
		System.out.println("Виберіть дохтора: ");
		card.setHealthWorker(hws.get(Integer.parseInt(scanner.nextLine())));

		// ----------------------------------------------------

//		DaoManager<Module> modMan = new DaoManager<Module>();
		List<Module> mods = new LinkedList<Module>(department.getModules());
		Set<ModuleData> modulesData = new HashSet<ModuleData>();

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
			Map<String, String> data = new HashMap<String, String>();

			do {
				Set<String> paramNames = module.getParameters().keySet();
				List<String> names = new LinkedList<String>(paramNames);
				for (ListIterator<String> iterator = names.listIterator(); iterator
						.hasNext();) {
					String name = iterator.next();
					System.out
							.println((iterator.nextIndex() - 1) + ". " + name);
				}
				System.out.print("виберіть параметр: ");
				String paramName = names.get(Integer.parseInt(scanner
						.nextLine()));
				String type = module.getParameter(paramName).getField()
						.getType().name();

				if (type.equals(FieldTypes.SELECTBOX.name())) {
					Set<String> paramVal = module.getParameter(paramName)
							.getField().getValues();
					List<String> values = new LinkedList<String>(paramVal);

					for (ListIterator<String> iterator2 = values.listIterator(); iterator2
							.hasNext();) {
						String value = iterator2.next();
						System.out.println((iterator2.nextIndex() - 1) + ". "
								+ value);
					}

					System.out.print("виберіть значення: ");
					data.put(paramName, values.get(Integer.parseInt(scanner
							.nextLine())));
				} else if (type.equals(FieldTypes.TEXTBOX.name())) {
					System.out.print("введіть значення: ");
					data.put(paramName, scanner.nextLine());
				} else if (type.equals(FieldTypes.NORM.name())) {
					Set<String> paramVal = module.getParameter(paramName)
							.getField().getValues();
					List<String> values = new LinkedList<String>(paramVal);

					System.out.print("введіть значення: norma min="
							+ values.get(0) + " , max=" + values.get(1));
					data.put(paramName, scanner.nextLine());
				} else if (type.equals(FieldTypes.NORM_SEX.name())) {
					Set<String> paramVal = module.getParameter(paramName)
							.getField().getValues();
					List<String> values = new LinkedList<String>(paramVal);

					if (card.getPatient().getSex().equals(SexTypes.FEMALE)) {
						System.out.print("You are FEMALE: norma min="
								+ values.get(0) + " , max=" + values.get(1));
					} else if (card.getPatient().getSex().equals(SexTypes.MALE)) {
						System.out.print("You are MALE: norma min="
								+ values.get(2) + " , max=" + values.get(3));
					}

					System.out.print("введіть значення: ");
					data.put(paramName, scanner.nextLine());
				}

				System.out.print("ще параметри <x> - exit: ");
			} while (!scanner.nextLine().equals("x"));
			moduleData.setParameters(data);
			modulesData.add(moduleData);
			System.out.print("ще модулі <x> - exit:     "+modulesData.size());
		} while (!scanner.nextLine().equals("x"));
		


		card.setModulesData(modulesData);

		// ----------------------------------------------------

		new DaoManager<Card>().newInstance(card);

	}
}
