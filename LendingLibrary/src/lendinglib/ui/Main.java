package lendinglib.ui;

import lendinglib.models.Book;
import lendinglib.models.Customer;
import lendinglib.models.CustomerNotFoundException;
import lendinglib.models.CustomerRecords;
import lendinglib.models.DVD;
import lendinglib.models.Loan;
import lendinglib.models.LoanAlreadyExistsException;
import lendinglib.models.LoanRegistry;
import lendinglib.models.MaterialCatalogInterface;
import lendinglib.models.MaterialCatalogMemoryVersion;
import lendinglib.utilities.GenderType;

public class Main {

	public static void main(String[] args) {

		MaterialCatalogInterface materialCatalog = new MaterialCatalogMemoryVersion();

		Book book1 = new Book("1001", "Sky", "Smith", "8888", "anytown", 200);
		Book book2 = new Book("221X", "Ground", "Jones", "7777", "Stockhlm", 100);
		Book book3 = new Book("9120", "Learning French", "Jones", "7777", "Stockhlm", 100);
		Book book4 = new Book("223X", "Learning More French", "Jones", "65656", "Stockholm", 100);
		Book book5 = new Book("1X2X", "Enough French Already", "Jones", "7777", "Stockhlm", 100);

        DVD dvd1 = new DVD("1", "An epic film about Java", "Liljeholmen", "Steven",
		"9987", 120);
		DVD dvd2 = new DVD("2", "An epic film about Java", "Liljeholmen", "Steven",
  		"9987", 120);
		System.out.println("Title is: " + dvd1.getTitle());
		System.out.println("DVD is not licenced: " + dvd1.getLicence());

		//book1.relocate("Midsommarkransen");

		materialCatalog.addMaterial(book1);
		materialCatalog.addMaterial(book2);
		materialCatalog.addMaterial(book3);
		materialCatalog.addMaterial(book4);
		materialCatalog.addMaterial(book5);
		materialCatalog.addMaterial(dvd1);
		materialCatalog.addMaterial(dvd2);
		

		UI ui = new UI();
		ui.printHeader();

		ui.printMaterialCatalog(materialCatalog.getMaterialMap());

		// Checked exceptions
		// try {
		// // Book foundBook = bookCatalog.findBook("sky");
		// Book foundBook = bookCatalog.findBook("himmel");
		// System.out.println("We found " + foundBook.getTitle());
		// } catch (BookNotFoundException e) {
		// System.out.println("The book wasn't found");
		// }
		//
		// // Unchecked exceptions
		// int myTest = 1;
		// try {
		// if (myTest != 2) {
		// throw new RuntimeException("Something went wrong");
		// }
		// } catch (RuntimeException e) {
		// System.out.println("Do nothing here for RuntimeException");
		// }

		CustomerRecords customerRecord = new CustomerRecords();
		
		Customer customer1 = new Customer("Mr", "John", "Smith", "Stockholm", "999999", "John@mail", 22,
				GenderType.MALE, true);
		customerRecord.addCustomer(customer1);
		Customer customer2 = new Customer("Mr", "James", "Smith", "Stockholm", "999999", "James@Smith", 23,
				GenderType.MALE, true);
		customerRecord.addCustomer(customer2);
		try {
			customerRecord.findByMailingName(customer2.getMailingName());
		} 
		catch (CustomerNotFoundException e) {
			System.out.println("Customer not found:" + customer2.getEmail());
			
		}
		
		 
//		 System.out.println("ExpiryDate:" + customer1.getExpiryDate());
//		 System.out.println("Email:" + customer1.getEmail());
//		
//		 System.out.println("Customer can lend?: " + dvd1.lend(customer1));
//		 System.out.println("DVD is not licensed: " + dvd1.getLicence());
//		 dvd1.licence(); // DVD set to licensed
//		 System.out.println("DVD is not licensed: " + dvd1.getLicence());
//		 System.out.println("Customer can lend?: " + dvd1.lend(customer1));
//		 System.out.println("Customer can lend?: " + dvd1.lend(customer1));
//		 System.out.println("Customer can lend?: " + dvd1.lend(customer2));
//		
//		 System.out.println("Customer can lend?: " + book1.lend(customer1));
//		 System.out.println("Customer can lend?: " + book1.lend(customer1));
//		
//		 System.out.println("Loan period is: " + dvd1.getLoanPeriod());
//		 System.out.println("Loan period is: " + book1.getLoanPeriod());
//		
//		 System.out.println(book1);
//		 System.out.println(dvd1);
//		
//		 System.out.println(dvd1.equals(dvd2));
//		 System.out.println(dvd1.equals(null));
//		 System.out.println(customer1.equals(customer1));
//		 System.out.println(dvd1.equals(null));
//		
//		 Loan firstLoan = new Loan(1, customer1, book1);
//		 System.out.println(firstLoan.getDueDate());
//		 System.out.println(firstLoan);
//		
//		 LoanRegistry registry = new LoanRegistry();
//		
//		 try {
//		 registry.addLoan(firstLoan);
//		 System.out.println("addLoan worked");
//		 } catch (LoanAlreadyExistsException e) {
//		 System.out.println("addLoan did not work");
//		 }
//		
//		 try {
//		 registry.addLoan(firstLoan);
//		 System.out.println("addLoan worked");
//		 } catch (LoanAlreadyExistsException e) {
//		 System.out.println("addLoan did not work");
//		 }
//		
//		 System.out.println(registry.isBookLoan(book1.getID()));
//		 firstLoan.endLoan();
//		 System.out.println(registry.isBookLoan(book1.getID()));
	}

}
