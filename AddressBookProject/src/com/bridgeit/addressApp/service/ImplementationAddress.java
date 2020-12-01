package com.bridgeit.addressApp.service;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import com.bridgeit.addressApp.model.Person;

public class ImplementationAddress implements AddressBookInter {
	Scanner scanner = new Scanner(System.in);
	HashMap<String, ArrayList> hashMap = new HashMap<>();
	ArrayList<Person> arrayList = null;

	public void add() {
		fileReader();
		System.out.println("Enter the AddressBook name");
		String addressBookName = scanner.next();
		Person person = new Person();
		System.out.println("Enter the first name");
		String firstName = scanner.next();
		person.setFirstName(firstName);
		System.out.println("Enter the last name");
		String lastName = scanner.next();
		person.setLastName(lastName);
		System.out.println("Enter the Address");
		String address = scanner.next();
		person.setAddress(address);
		System.out.println("Enter the city");
		String city = scanner.next();
		person.setCity(city);
		System.out.println("Enter the state");
		String state = scanner.next();
		person.setState(state);
		System.out.println("Enter the zip");
		int zip = scanner.nextInt();
		person.setZip(zip);
		System.out.println("enter the mobile number");
		long mobNumber = scanner.nextLong();
		person.setMobNumber(mobNumber);
		// arrayList.add(p1);
		if (hashMap.get(addressBookName) == null)
			hashMap.put(addressBookName, new ArrayList<Person>());
		hashMap.get(addressBookName).add(person);
		System.out.println("succesfully added");
		fileWrite();
		fileReader();

	}

	public void delete() {
		fileReader();
		System.out.println("Enter the AddressBook name");
		String addressBookName = scanner.next();
		arrayList = hashMap.get(addressBookName);
		System.out.println("Enter the person name");
		String name = scanner.next();
		for (int i = 0; i < arrayList.size(); i++) {
			if (name.equals(arrayList.get(i).getFirstName())) {
				arrayList.remove(i);
			}
		}
		fileWrite();
		fileReader();
		System.out.println("Successfully deleted");

	}

	public void edit() {
		fileReader();
		System.out.println("Enter the AddressBook name");
		String addressBookName = scanner.next();
		arrayList = hashMap.get(addressBookName);
		System.out.println("Enter the Person Name");
		String name = scanner.next();
		for (int i = 0; i < arrayList.size(); i++) {
			if (name.equals(arrayList.get(i).getFirstName())) {
				System.out.println("Enter the option to Edit");
				System.out.println("1.FirstName");
				System.out.println("2.LastName");
				System.out.println("3.Address");
				System.out.println("4.City");
				System.out.println("5.State");
				System.out.println("6.zip");
				System.out.println("7.mobile Number");
				int option = scanner.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter the first name");
					String firstName = scanner.next();
					arrayList.get(i).setFirstName(firstName);
					break;
				case 2:
					System.out.println("Enter the last name");
					String lastName = scanner.next();
					arrayList.get(i).setLastName(lastName);
					break;
				case 3:
					System.out.println("Enter the Address");
					String address = scanner.next();
					arrayList.get(i).setAddress(address);
					break;
				case 4:
					System.out.println("Enter the city");
					String city = scanner.next();
					arrayList.get(i).setCity(city);
					break;
				case 5:
					System.out.println("Enter the state");
					String state = scanner.next();
					arrayList.get(i).setState(state);
					break;
				case 6:
					System.out.println("Enter the zip");
					int zip = scanner.nextInt();
					arrayList.get(i).setZip(zip);
					break;
				case 7:
					System.out.println("enter the mobile number");
					long mobNumber = scanner.nextLong();
					arrayList.get(i).setMobNumber(mobNumber);
					break;
				default:
					System.out.println("Invalid Option");
				}
			}
		}
		fileWrite();
		fileReader();
		System.out.println("sucessfully edited");
	}

	public void fileWrite() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\vishakha\\Desktop\\AddressBook.ser.txt");
			ObjectOutput ObjectOutput = new ObjectOutputStream(fileOutputStream);
			ObjectOutput.writeObject(hashMap);
			ObjectOutput.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fileReader() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new FileInputStream("C:\\Users\\vishakha\\Desktop\\AddressBook.ser.txt"));
			hashMap = (HashMap) objectInputStream.readObject();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void sorting() {
		fileReader();
		System.out.println("Enter the AddressBook name");
		String addressBookName = scanner.next();
		System.out.println("Enter the option to sort");
		System.out.println("1 sort By First Name");
		System.out.println("2 sort By zip");
		int option = scanner.nextInt();
		ArrayList arrayList1 = new ArrayList();
		switch (option) {
		case 1:
			arrayList = hashMap.get(addressBookName);

			for (int i = 0; i < arrayList.size(); i++) {
				arrayList1.add(arrayList.get(i).getFirstName());
			}
			Collections.sort(arrayList1);
			System.out.println("_____________________________________________________________________________");
			System.out.println("\t\t\t\t" + addressBookName);
			System.out.println("_____________________________________________________________________________");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "FirstName", "LastName", "Address", "City",
					"State", "Zip", "MobNO");
			System.out.println("..............................................................................");
			for (int i = 0; i < arrayList1.size(); i++) {
				for (int j = 0; j < arrayList1.size(); j++) {
					if (arrayList1.get(i).equals(arrayList.get(j).getFirstName())) {
						System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
								arrayList.get(j).getFirstName(), arrayList.get(j).getLastName(),
								arrayList.get(j).getAddress(), arrayList.get(j).getCity(), arrayList.get(j).getState(),
								arrayList.get(j).getZip(), arrayList.get(j).getMobNumber());
						System.out.println(
								"..............................................................................");
					}
				}
			}
			break;
		case 2:
			arrayList = hashMap.get(addressBookName);
			for (int i = 0; i < arrayList.size(); i++) {
				arrayList1.add(arrayList.get(i).getZip());
			}
			Collections.sort(arrayList1);
			System.out.println("_____________________________________________________________________________");
			System.out.println("\t\t\t\t" + addressBookName);
			System.out.println("_____________________________________________________________________________");
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "FirstName", "LastName", "Address", "City",
					"State", "Zip", "MobNO");
			System.out.println("..............................................................................");
			for (int i = 0; i < arrayList1.size(); i++) {
				for (int j = 0; j < arrayList1.size(); j++) {
					if (arrayList1.get(i).equals(arrayList.get(j).getZip())) {

						System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
								arrayList.get(j).getFirstName(), arrayList.get(j).getLastName(),
								arrayList.get(j).getAddress(), arrayList.get(j).getCity(), arrayList.get(j).getState(),
								arrayList.get(j).getZip(), arrayList.get(j).getMobNumber());
						System.out.println(
								"..............................................................................");
					}
				}
			}

		}
	}

	public void display() {
		fileReader();
		System.out.println("Enter the addressBook name");
		String name = scanner.next();
		System.out.println("_____________________________________________________________________________");
		System.out.println("\t\t\t\t" + name);
		System.out.println("_____________________________________________________________________________");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "FirstName", "LastName", "Address", "City",
				"State", "Zip", "MobNO");
		arrayList = hashMap.get(name);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", arrayList.get(i).getFirstName(),
					arrayList.get(i).getLastName(), arrayList.get(i).getAddress(), arrayList.get(i).getCity(),
					arrayList.get(i).getState(), arrayList.get(i).getZip(), arrayList.get(i).getMobNumber());
			System.out.println("..............................................................................");
		}
	}

	public void searchByName() {
		fileReader();
		System.out.println("Eneter the addressBook name");
		String name = scanner.next();
		System.out.println("entre the person name");
		String personName = scanner.next();
		System.out.println("_____________________________________________________________________________");
		System.out.println("\t\t\t\t" + name);
		System.out.println("_____________________________________________________________________________");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "FirstName", "LastName", "Address", "City",
				"State", "Zip", "MobNO");
		arrayList = hashMap.get(name);
		for (int i = 0; i < arrayList.size(); i++) {
			if (personName.equals(arrayList.get(i).getFirstName())) {
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", arrayList.get(i).getFirstName(),
						arrayList.get(i).getLastName(), arrayList.get(i).getAddress(), arrayList.get(i).getCity(),
						arrayList.get(i).getState(), arrayList.get(i).getZip(), arrayList.get(i).getMobNumber());
				System.out.println("..............................................................................");

			}
		}

	}
}