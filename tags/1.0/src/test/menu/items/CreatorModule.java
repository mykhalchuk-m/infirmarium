package test.menu.items;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.FieldTypes;

public class CreatorModule implements MenuItem {

	private String name = "module";

	public String getName() {
		return name;
	}

	public void executeItem() {
		Scanner scanner = new Scanner(System.in);
		Module newModule = new Module();
		System.out.print("введіть імя модуля: ");
		newModule.setModuleName(scanner.nextLine());
		List<Field> parameters = new ArrayList<Field>();
		do {
			System.out.print("імя параметра: ");
			Field field = new Field();
			field.setName(scanner.nextLine());
			System.out.println("тип поля: ");
			for (int i = 0; i < FieldTypes.values().length; i++) {
				System.out.println(i + ". " + FieldTypes.values()[i].name());
			}
			System.out.print("номер типу поля: ");
			int pType = Integer.parseInt(scanner.nextLine());
			String type = FieldTypes.values()[pType].name();

			if (type.equals(FieldTypes.SELECTBOX.name())) {
				String selectV = "";
				System.out.print("введіть значення, (<x> - вийти): ");
				while (!(selectV = scanner.nextLine()).equals("x")) {
					field.addValue(selectV);
					System.out.print("введіть значення, (<x> - вийти): ");
				}

				field.setType(FieldTypes.SELECTBOX);

			} else if (type.equals(FieldTypes.TEXTBOX.name())) {
				field.setType(FieldTypes.TEXTBOX);
			}

			parameters.add(field);
			System.out.print("більше параметрів не вводити? (<x> - вийти): ");
		} while (!scanner.nextLine().equals("x"));

		newModule.setParameters(parameters);

		DaoManager<Department> daoManagerDepart = new DaoManager<Department>();
		List<Department> deps = daoManagerDepart.getInstance(Department.class,
				new ArrayList<Param>());
		for (ListIterator<Department> iterator = deps.listIterator(); iterator
				.hasNext();) {
			Department department = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ department.getName());
		}
		System.out.print("Виберіть в який відділ внести лікаря: ");
		Department update = deps.get(Integer.parseInt(scanner.nextLine()));
		update.addModule(newModule);
		daoManagerDepart.updateInstance(update);
	}
}
