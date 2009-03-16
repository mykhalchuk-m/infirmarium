package test.menu.items;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;

public class CreatorHW implements MenuItem {

	private String name = "heath worker";

	public String getName() {
		return name;
	}

	public void executeItem() {

		Scanner scanner = new Scanner(System.in);

		HealthWorker hw = new HealthWorker();

		System.out.print("first name: ");
		hw.setFirstName(scanner.nextLine());

		System.out.print("last name: ");
		hw.setLastName(scanner.nextLine());

		System.out.print("middle name: ");
		hw.setMiddleName(scanner.nextLine());

		System.out.print("speciality: ");
		hw.setSpeciality(scanner.nextLine());
		
		DaoManager<Department> daoManagerDepart = new DaoManager<Department>();
		List<Department> deps = daoManagerDepart.getInstance(Department.class, new ArrayList<Param>());
		for (ListIterator<Department> iterator = deps.listIterator(); iterator.hasNext();) {
			Department department = iterator.next();
			System.out.println((iterator.nextIndex()-1)+". "+department.getName());
		}
		System.out.print("Виберіть в який відділ внести лікаря: ");
		Department update = deps.get(Integer.parseInt(scanner.nextLine()));
		update.addHealthWorker(hw);
		daoManagerDepart.updateInstance(update);
	}

}
