package test;

import java.util.Scanner;

import test.menu.MenuCreator;

public class TEST {

	public static void main(String[] args) {
 
		while (true) {
			MenuCreator menuCreator = new MenuCreator();
			menuCreator.printItemsName();
			System.out.print("(<0> - out) ----> ");
			Scanner scanner = new Scanner(System.in);
			int index = Integer.parseInt(scanner.nextLine());
			if (index == 0) {
				System.exit(0);
			}
			menuCreator.exexItem(index);
		}
	}
}
