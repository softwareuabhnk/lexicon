package lendinglib.models;

import java.util.Date;
import java.util.GregorianCalendar;

import lendinglib.utilities.GenderType;

public class Customer {
	
	private String title;
	private String firstName;
	private String surName;
	private String address;
	private String phoneNo;
	private String email;
	private int customerNo;
	private GenderType gender;
	private boolean isValid = true;
	private Date expiryDate;
	
	public Customer(String title, String firstName, String surName, String address, 
			String phoneNo, String email, int customerNo, GenderType gender, boolean isValid ) {
		System.out.println("New customer object created");
		setName(title, firstName, surName);
		setData(address, phoneNo, email, customerNo, gender, isValid);
	}
	
	public void setData(String address, String phoneNo, String email, int customerNo, GenderType gender, Boolean isValid) {
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;	
		this.customerNo = customerNo;
		this.gender = gender;
		this.isValid = isValid;
		
		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR, 1);
		this.expiryDate = gCal.getTime();	
	}

	public Date getExpiryDate() {
		return expiryDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSurName() {
		return surName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerNo;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isValid ? 1231 : 1237);
		result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerNo != other.customerNo)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (isValid != other.isValid)
			return false;
		if (phoneNo == null) {
			if (other.phoneNo != null)
				return false;
		} else if (!phoneNo.equals(other.phoneNo))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getTitle() {
		return title;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public GenderType getGender() {
		return gender;
	}
	public boolean getIsValid() {
		return isValid;
	}
	
	private void setName(String title, String firstName, String surName) {
		this.title = title;
		this.firstName = firstName;
		this.surName = surName;	
	}
	
	public String getMailingName() {
		
		String mailingName; 
		mailingName = title;
		mailingName = mailingName.concat(" ");
		mailingName = mailingName.concat(firstName.substring(0,1));
		mailingName = mailingName.concat(" ");
		mailingName = mailingName.concat(surName);
		
		return mailingName;
	}
}
