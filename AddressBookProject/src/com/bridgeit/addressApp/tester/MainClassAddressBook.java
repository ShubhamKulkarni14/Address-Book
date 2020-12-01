package com.bridgeit.addressApp.tester;

import java.util.Scanner;
import com.bridgeit.addressApp.controller.AddressController;

public class MainClassAddressBook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AddressController addressConroller = new AddressController();
		int number;
		System.out.println("Hi welcome to AddressBook");
		do {
			System.out.println("Enter the following choice");
			System.out.println("1 for add");
			System.out.println("2 for delete");
			System.out.println("3 for edit");
			System.out.println("4 for sort ");
			System.out.println("5 for display");
			System.out.println("6 for search By name");
			System.out.println("7 for exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				addressConroller.add();
				break;
			case 2:
				addressConroller.delete();
				break;
			case 3:
				addressConroller.edit();
				break;
			case 4:
				addressConroller.sorting();
				break;
			case 5:
				addressConroller.display();
				break;
			case 6:
				addressConroller.searchByName();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("To continue this press 1");
			number = scanner.nextInt();
		} while (number == 1);
		scanner.close();
	}

}
