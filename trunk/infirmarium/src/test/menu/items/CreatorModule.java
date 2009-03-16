package test.menu.items;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.hospital.manageres.DaoManager;
import com.hospital.modulecreator.Field;
import com.hospital.modulecreator.FieldTypes;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.Record;

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
		Map<String, Record> parameters = new HashMap<String, Record>();
		do {
			System.out.print("імя параметра: ");
			String pName = scanner.nextLine();
			System.out.println("тип поля: ");
			for (int i = 0; i < FieldTypes.values().length; i++) {
				System.out.println(i + ". " + FieldTypes.values()[i].name());
			}
			System.out.print("номер типу поля: ");
			int pType = Integer.parseInt(scanner.nextLine());
			String type = FieldTypes.values()[pType].name();
			Field field = null;
			if (type.equals(FieldTypes.SELECTBOX.name())) {
				String selectV = "";
				Set<String> values = new HashSet<String>();
				System.out.print("введіть значення, <x> - вийти: ");
				while (!(selectV = scanner.nextLine()).equals("x")) {
					values.add(selectV);
					System.out.print("введіть значення, <x> - вийти: ");
				}
				field = new Field();
				field.setType(FieldTypes.SELECTBOX);
				field.setValues(values);

			} else if (type.equals(FieldTypes.TEXTBOX.name())) {
				field = new Field();
				field.setType(FieldTypes.TEXTBOX);
				field.setValues(new HashSet<String>());
			} else if (type.equals(FieldTypes.NORM.name())) {
				Set<String> values = new HashSet<String>();
				System.out.print("введіть значення min ");
				values.add(scanner.nextLine());

				System.out.print("введіть значення max ");
				values.add(scanner.nextLine());

				field = new Field();
				field.setType(FieldTypes.NORM);
				field.setValues(values);
			} else if (type.equals(FieldTypes.NORM_SEX.name())) {
				Set<String> values = new HashSet<String>();

				System.out.print("MALE введіть значення min  ");
				values.add(scanner.nextLine());

				System.out.print("MALE введіть значення max ");
				values.add(scanner.nextLine());

				System.out.print("FEMALE введіть значення min  ");
				values.add(scanner.nextLine());

				System.out.print("FEMALE введіть значення max ");
				values.add(scanner.nextLine());

				field = new Field();
				field.setType(FieldTypes.NORM_SEX);
				field.setValues(values);
			}

			Record record = new Record();
			record.setField(field);
			parameters.put(pName, record);
			System.out.print("більше параметрів не вводити <x> - вийти?: ");
		} while (!scanner.nextLine().equals("x"));

		newModule.setParameters(parameters);

		new DaoManager<Module>().newInstance(newModule);
	}
}
