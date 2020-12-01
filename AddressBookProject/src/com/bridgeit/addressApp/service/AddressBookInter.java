package com.bridgeit.addressApp.service;

public interface AddressBookInter {
	/**
	 * this method is used to add the person in the Address Book
	 * 
	 */
	void add();

	/**
	 * this method is used to delete the person in the Address Book
	 * 
	 */
	void delete();

	/**
	 * this method is used to Edit the contents of person in the address Book by
	 * first name,Last name,Mobile Number,Zip,city,state
	 * 
	 */
	void edit();

	/**
	 * this method is used to sort the persons by first name and zip
	 * 
	 */
	void sorting();

	/**
	 * this method is used to display the persons in the Address Book
	 * 
	 */
	void display();

	/**
	 * this method is used to search the persons the address Book by name
	 * 
	 */
	void searchByName();

}