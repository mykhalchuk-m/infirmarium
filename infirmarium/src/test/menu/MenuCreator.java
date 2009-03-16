package test.menu;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import test.menu.items.CreatorCard;
import test.menu.items.CreatorDepartment;
import test.menu.items.CreatorHW;
import test.menu.items.CreatorModule;
import test.menu.items.CreatorPatient;
import test.menu.items.CreatorViewCard;
import test.menu.items.MenuItem;

public class MenuCreator {
	private List<MenuItem> menu = new LinkedList<MenuItem>();

	public MenuCreator() {
		init();
	}

	private void init() {
		menu.add(new CreatorModule());
		menu.add(new CreatorCard());
		menu.add(new CreatorHW());
		menu.add(new CreatorPatient());
		menu.add(new CreatorDepartment());
		menu.add(new CreatorViewCard());
	}

	public void printItemsName() {
		for (ListIterator<MenuItem> iterator = menu.listIterator(); iterator
				.hasNext();) {
			MenuItem item = iterator.next();
			System.out.println((iterator.nextIndex()) + ". " + item.getName());
		}
	}

	public void exexItem(int index) {
		try {
			MenuItem item = menu.get(index - 1);
			item.executeItem();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("<invalid index>");
		}
	}
}
