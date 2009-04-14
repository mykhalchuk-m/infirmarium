package test.menu.items;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.FieldTypes;
import com.hospital.modulecreator.field.Norm;
import com.hospital.modulecreator.field.SexNorm;

public class CreatorAnalysis implements MenuItem {

	private String name = "analysis";

	public void executeItem() {
		Scanner scanner = new Scanner(System.in);
		Analysis newAnalysis = new Analysis();
		System.out.print("введ≥ть ≥м€ анал≥зу: ");
		newAnalysis.setModuleName(scanner.nextLine());
		List<Field> parameters = new ArrayList<Field>();
		do {
			System.out.print("≥м€ параметра: ");
			Field field = new Field();
			field.setName(scanner.nextLine());
			System.out.println("тип пол€: ");
			for (int i = 0; i < FieldTypes.values().length; i++) {
				System.out.println(i + ". " + FieldTypes.values()[i].name());
			}
			System.out.print("номер типу пол€: ");
			int pType = Integer.parseInt(scanner.nextLine());
			String type = FieldTypes.values()[pType].name();

			if (type.equals(FieldTypes.SELECTBOX.name())) {
				String selectV = "";
				System.out.print("введ≥ть значенн€, (<x> - вийти): ");
				while (!(selectV = scanner.nextLine()).equals("x")) {
					field.addValue(selectV);
					System.out.print("введ≥ть значенн€, (<x> - вийти): ");
				}

				field.setType(FieldTypes.SELECTBOX);
			} else if (type.equals(FieldTypes.TEXTBOX.name())) {

				field.setType(FieldTypes.TEXTBOX);
			} else if (type.equals(FieldTypes.NORM.name())) {
				Norm norm = new Norm();
				System.out.print("¬вед≥ть верхню межу норми: ");
				norm.setMaxValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("¬вед≥ть нижню межу норми: ");
				norm.setMinValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("¬вед≥ть розм≥рн≥сть норми: ");
				norm.setUnit(scanner.nextLine());
				field.setType(FieldTypes.NORM);
				field.setNorm(norm);// one - to - one!!!!!!!!!!!!!!!!!!!!!!!!!!
				norm.setField(field);

			} else if (type.equals(FieldTypes.SEX_NORM.name())) {
				SexNorm sexNorm = new SexNorm();
				System.out.print("¬вед≥ть верхню межу норми чолов≥ка: ");
				sexNorm.setMaxMaleValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("¬вед≥ть нижню межу норми чолов≥ка: ");
				sexNorm.setMinMaleValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("¬вед≥ть верхню межу норми ж≥нки: ");
				sexNorm.setMaxFemaleValue(Double
						.parseDouble(scanner.nextLine()));
				System.out.print("¬вед≥ть нижню межу норми ж≥нки: ");
				sexNorm.setMinFemaleValue(Double
						.parseDouble(scanner.nextLine()));
				System.out.print("¬вед≥ть розм≥рн≥сть норми: ");
				sexNorm.setUnit(scanner.nextLine());
				field.setType(FieldTypes.SEX_NORM);
				field.setSexNorm(sexNorm);// one - to - one!!!!!!!!!!!!!!!
				sexNorm.setField(field);
			}

			parameters.add(field);
			System.out.print("б≥льше параметр≥в не вводити? (<x> - вийти): ");
		} while (!scanner.nextLine().equals("x"));

		newAnalysis.setParameters(parameters);

		DaoManager<Department> daoManagerDepart = new DaoManager<Department>();
		List<Department> deps = daoManagerDepart.getInstance(Department.class,
				new ArrayList<Param>());
		for (ListIterator<Department> iterator = deps.listIterator(); iterator
				.hasNext();) {
			Department department = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ department.getName());
		}
		System.out.print("¬ибер≥ть в €кий в≥дд≥л внести л≥кар€: ");
		Department update = deps.get(Integer.parseInt(scanner.nextLine()));
		update.addAnalysis(newAnalysis);
		daoManagerDepart.updateInstance(update);

	}

	public String getName() {
		return name;
	}

}
