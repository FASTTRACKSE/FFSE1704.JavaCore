package chapter14.lamdas.ui;

import java.util.ArrayList;

import chapter14.lamdas.business.Contact;
import chapter14.lamdas.business.FilterContact;

public class LamdaApp {
	
	// Loc danh sach truyen thong - theo so dien thoai
	public static ArrayList<Contact> filterContactWithPhone(ArrayList<Contact> contacts) {
		ArrayList<Contact> resultContacts = new ArrayList<>();

		for (Contact contact : contacts) {
			if (contact.getPhone() != null)
				resultContacts.add(contact);
		}
		return resultContacts;
	}

	// Loc danh sach truyen thong - theo email...
	public static ArrayList<Contact> filterContactWithEmail(ArrayList<Contact> contacts) {
		ArrayList<Contact> resultContacts = new ArrayList<>();

		for (Contact contact : contacts) {
			if (contact.getEmail() != null)
				resultContacts.add(contact);
		}
		return resultContacts;
	}

	// Loc danh sach su dung bieu thuc Lambdas
	public static ArrayList<Contact> filterContacts(ArrayList<Contact> contacts, FilterContact condition) {
		ArrayList<Contact> filteredContacts = new ArrayList<>();
		for (Contact c : contacts) {
			if (condition.filterContact(c))
				filteredContacts.add(c);
		}
		return filteredContacts;
	}

	public static void main(String[] args) {
		ArrayList<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Nguyen Van Anh", null, null));
		contacts.add(new Contact("Nguyen Thi Binh", "binh@gmail.com", null));
		contacts.add(new Contact("Chu Canh Chieu", null, "0909999999"));
		contacts.add(new Contact("Hoang Van Duc", "duc@gmail.com", null));
		contacts.add(new Contact("Nguyen Thi Thu Giang", null, "088888888"));

		System.out.println("FULL CONTACTS LIST");
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		System.out.println("-------------------");

		System.out.println("CONTACTS WITH PHONE NUMBER");
//		ArrayList<Contact> contactHasPhone = filterContactWithPhone(contacts);
//		for (Contact contact : contactHasPhone) {
//			System.out.println(contact);
//		}
		ArrayList<Contact> contactHasPhone = filterContacts(contacts, c -> c.getPhone() != null);
		for (Contact contact : contactHasPhone) {
			System.out.println(contact);
		}
			
		System.out.println("-------------------");

		System.out.println("CONTACTS WITH EMAIL");
		ArrayList<Contact> contactHasEmail = filterContacts(contacts, c -> c.getEmail() == null);
		for (Contact contact : contactHasEmail) {
			System.out.println(contact);
		}

		System.out.println("-------------------");
	}

}
