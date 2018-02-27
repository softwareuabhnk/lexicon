package lendinglib.models;
import java.util.HashSet;

public class CustomerRecords {

	private HashSet<Customer> customerRecords;

	public CustomerRecords() {
		customerRecords = new HashSet<Customer>();
	}

	public void addCustomer(Customer customer) {
		if (customerRecords.add(customer)) {
			System.out.println("Customer added");
		} 
		else {
			System.out.println("Customer not added");
		}
	}

	public Customer findByMailingName(String name) throws CustomerNotFoundException {

		name = name.trim();

		for (Customer nextCustomer : customerRecords) {

			System.out.println("name is :" + name);
			System.out.println(" mailing name is :" + nextCustomer.getMailingName());
			//if (nextCustomer.getMailingName().equalsIgnoreCase(name)) {
			if (nextCustomer.getMailingName().equalsIgnoreCase(name)) {
				return nextCustomer;
			}

		}

		throw new CustomerNotFoundException();
		// return null;

	}

	 public int getNumberOfCustomers() {
	 return customerRecords.size();
	 }
}
