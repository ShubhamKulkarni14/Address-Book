package com.bridgeit.addressApp.controller;

import com.bridgeit.addressApp.service.AddressBookInter;
import com.bridgeit.addressApp.service.ImplementationAddress;

public class AddressController {
	AddressBookInter addressBookInter = new ImplementationAddress();

	public void add() {
		addressBookInter.add();
	}

	public void delete() {
		addressBookInter.delete();
	}

	public void edit() {
		addressBookInter.edit();
	}

	public void sorting() {
		addressBookInter.sorting();
	}

	public void display() {
		addressBookInter.display();
	}

	public void searchByName() {
		addressBookInter.searchByName();
	}

}