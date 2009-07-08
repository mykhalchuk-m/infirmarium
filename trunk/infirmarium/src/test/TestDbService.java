package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.hospital.cards.Card;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.manageres.DaoManager;
import com.hospital.manageres.Param;
import com.hospital.service.DbService;

public class TestDbService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DaoManager<Department> patMan = new DaoManager<Department>();
		List<Department> pats = patMan.getInstance(Department.class,
				new ArrayList<Param>());
		
		for (ListIterator<Department> iterator = pats.listIterator(); iterator
		.hasNext();) {
			Department patient = iterator.next();
			System.out.println((iterator.nextIndex() - 1) + ". "
					+ patient.getName() );
		}
		System.out.println("������� ��������: ");
		Department patientSet = pats.get(Integer.parseInt(scanner.nextLine()));
		
		
		
		///////////////////////////////////////////
		
		List<Card> list = DbService.getCardsByDepartment(patientSet);

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Card card = (Card) iterator.next();

			System.out.println(card.getId() + " , ");

		}

	}

}
