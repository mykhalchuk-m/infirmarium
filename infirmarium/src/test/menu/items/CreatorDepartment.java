package test.menu.items;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;

public class CreatorDepartment implements MenuItem {

	private String name = "department";

	public String getName() {
		return name;
	}

	public void executeItem() {

		Scanner scanner = new Scanner(System.in);

		Department d = new Department();

		System.out.print("name: ");
		d.setName(scanner.nextLine());

		System.out.print("add module (y/n):");
		while ((scanner.nextLine()).equals("y")) {
			DaoManager<Module> m = new DaoManager<Module>();
			List<Module> listM = m.getInstance(Module.class,
					new ArrayList<Param>());

			for (ListIterator<Module> iterator = listM.listIterator(); iterator
					.hasNext();) {
				Module module = (Module) iterator.next();
				System.out.println((iterator.nextIndex() - 1) + "  -  "
						+ module.getModuleName());
			}
			System.out.print("N module for add: ");
			d.addModule(listM.get(Integer.valueOf(scanner.nextLine())));

			System.out.print("add module (y/n): ");
			m.close();
		}
		// ////////////////////////

		System.out.print("add HealthWorker (y/n): ");

		while ((scanner.nextLine()).equals("y")) {
			DaoManager<HealthWorker> hw = new DaoManager<HealthWorker>();
			List<HealthWorker> listHealthWorker = hw.getInstance(
					HealthWorker.class, new ArrayList<Param>());

			for (ListIterator<HealthWorker> iterator = listHealthWorker
					.listIterator(); iterator.hasNext();) {
				HealthWorker healthWorker = (HealthWorker) iterator.next();
				System.out.println((iterator.nextIndex() - 1) + "  -  "
						+ healthWorker.getFirstName() + " "
						+ healthWorker.getLastName());
			}
			System.out.print("N HealthWorker for add:");
			d.addHealthWorker(listHealthWorker.get(Integer.valueOf(scanner
					.nextLine())));

			System.out.print("add HealthWorker (y/n):");
			hw.close();
		}

		// ////////////////////////////////////////
		System.out.println("add analyses (y/n): ");

		while ((scanner.nextLine()).equals("y")) {
			DaoManager<Analysis> an = new DaoManager<Analysis>();
			List<Analysis> analysisList = an.getInstance(Analysis.class,
					new LinkedList<Param>());
			for (ListIterator<Analysis> iterator = analysisList.listIterator(); iterator
					.hasNext();) {
				Analysis analysis = iterator.next();
				System.out.println((iterator.nextIndex() - 1) + ". "
						+ analysis.getModuleName());
			}
			System.out.print("N analysis for add: ");
			d
					.addAnalysis(analysisList.get(Integer.valueOf(scanner
							.nextLine())));
			System.out.println("add analyses (y/n): ");
			an.close();
		}
		new DaoManager<Department>().newInstance(d);
	}

}
