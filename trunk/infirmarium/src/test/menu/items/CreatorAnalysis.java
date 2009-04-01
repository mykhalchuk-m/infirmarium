package test.menu.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
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
		System.out.print("������ ��� ������: ");
		newAnalysis.setModuleName(scanner.nextLine());
		Map<String, Field> parameters = new HashMap<String, Field>();
		do {
			System.out.print("��� ���������: ");
			String pName = scanner.nextLine();
			System.out.println("��� ����: ");
			for (int i = 0; i < FieldTypes.values().length; i++) {
				System.out.println(i + ". " + FieldTypes.values()[i].name());
			}
			System.out.print("����� ���� ����: ");
			int pType = Integer.parseInt(scanner.nextLine());
			String type = FieldTypes.values()[pType].name();
			Field field = null;
			if (type.equals(FieldTypes.SELECTBOX.name())) {
				String selectV = "";
				field = new Field();
				System.out.print("������ ��������, (<x> - �����): ");
				while (!(selectV = scanner.nextLine()).equals("x")) {
					field.addValue(selectV);
					System.out.print("������ ��������, (<x> - �����): ");
				}

				field.setType(FieldTypes.SELECTBOX);
			} else if (type.equals(FieldTypes.TEXTBOX.name())) {

				field = new Field();
				field.setType(FieldTypes.TEXTBOX);
			} else if (type.equals(FieldTypes.NORM.name())) {
				Norm norm = new Norm();
				System.out.print("������ ������ ���� �����: ");
				norm.setMaxValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("������ ����� ���� �����: ");
				norm.setMinValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("������ ��������� �����: ");
				norm.setUnit(scanner.nextLine());
				field = new Field();
				field.setType(FieldTypes.NORM);
				field.setNorm(norm);// one - to - one!!!!!!!!!!!!!!!!!!!!!!!!!!
				norm.setField(field);

			} else if (type.equals(FieldTypes.SEX_NORM.name())) {
				SexNorm sexNorm = new SexNorm();
				System.out.print("������ ������ ���� ����� �������: ");
				sexNorm.setMaxMaleValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("������ ����� ���� ����� �������: ");
				sexNorm.setMinMaleValue(Double.parseDouble(scanner.nextLine()));
				System.out.print("������ ������ ���� ����� ����: ");
				sexNorm.setMaxFemaleValue(Double
						.parseDouble(scanner.nextLine()));
				System.out.print("������ ����� ���� ����� ����: ");
				sexNorm.setMinFemaleValue(Double
						.parseDouble(scanner.nextLine()));
				System.out.print("������ ��������� �����: ");
				sexNorm.setUnit(scanner.nextLine());
				field = new Field();
				field.setType(FieldTypes.SEX_NORM);
				field.setSexNorm(sexNorm);// one - to - one!!!!!!!!!!!!!!!
				sexNorm.setField(field);
			}
			
			parameters.put(pName, field);
			System.out.print("����� ��������� �� �������? (<x> - �����): ");
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
		System.out.print("������� � ���� ���� ������ �����: ");
		Department update = deps.get(Integer.parseInt(scanner.nextLine()));
		update.addAnalysis(newAnalysis);
		daoManagerDepart.updateInstance(update);

	}

	public String getName() {
		return name;
	}

}
