package lendinglib.models;

import java.util.Date;
import java.util.GregorianCalendar;

import lendinglib.utilities.LoanStatusType;

public class Loan {
	
	private int id;
	private Customer customer;
	private Book book;
	private Date startDate;
	private Date dueDate;
	private Date returnDate;
	private LoanStatusType status;
	
	public Loan(int id, Customer customer, Book book) {
		//super();
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.startDate = new Date();
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.DAY_OF_MONTH,14);
		this.dueDate = gCal.getTime();
		this.status = LoanStatusType.CURRENT;
	}
	
	@Override
	public String toString() {
		return "Loan [id=" + id + ", customer name=" + customer.getSurName() + ", book title=" + book.getTitle() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void endLoan() {
		status = LoanStatusType.HISTORIC;
		returnDate = new Date();
	}

	public LoanStatusType getStatus() {
		return status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Book getBook() {
		return book;
	}
	public Date getDueDate() {
		return dueDate;
	}
}
