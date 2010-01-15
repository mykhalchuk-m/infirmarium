package test.menu.items;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

import com.hospital.hr.BloodGroup;
import com.hospital.hr.Patient;
import com.hospital.hr.SexTypes;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;

public class CreatorPatient implements MenuItem {

	private String name = "patient";

	public String getName() {
		return name;
	}

	public void executeItem() {
		Scanner scanner = new Scanner(System.in);

		Patient p = new Patient();

		System.out.print("first name: ");
		p.setFirstName(scanner.nextLine());

		System.out.print("last name: ");
		p.setLastName(scanner.nextLine());

		System.out.print("middle name: ");
		p.setMiddleName(scanner.nextLine());

//		System.out.print("address: ");
//		p.setAddress(scanner.nextLine());

		p.setBirthday(new Date(System.currentTimeMillis()));

		DaoManager<BloodGroup> bg = new DaoManager<BloodGroup>();
		List<BloodGroup> listBG = bg.getInstance(BloodGroup.class,
				new ArrayList<Param>());
		for (ListIterator<BloodGroup> iterator = listBG.listIterator(); iterator
				.hasNext();) {
			BloodGroup bloodGroup2 = (BloodGroup) iterator.next();
			System.out.println((iterator.nextIndex() - 1) + " - "
					+ bloodGroup2.getBloodGroupValue());

		}

		System.out.print("# blood: ");
		p.setBloodGroup(listBG.get(Integer.valueOf(scanner.nextLine())));

		p.setSex(SexTypes.values()[new Random().nextInt(1)]);

		new DaoManager<Patient>().newInstance(p);
	}

}
