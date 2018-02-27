package lendinglib.models;

import java.util.ArrayList;

import lendinglib.utilities.LoanStatusType;

public class LoanRegistry {

	private ArrayList<Loan> loanRegistry;
    
	public LoanRegistry() {
		
		loanRegistry = new ArrayList<Loan>();
	}
	
	public void addLoan(Loan loan) throws LoanAlreadyExistsException {
		
		if (loanRegistry.contains(loan)) {
			throw new LoanAlreadyExistsException();
		}
		
		loanRegistry.add(loan);
	}
	
	public Loan findLoan(String bookId) throws LoanNotFoundException {
	
		for(Loan loan: loanRegistry) {
		
			if ((loan.getBook().getID().equals(bookId)) && (loan.getStatus() == LoanStatusType.CURRENT)) {
				
				return loan;
			}	
		}
		throw new LoanNotFoundException();
	}
		
	public boolean isBookLoan(String bookId) {
		try {
			Loan foundLoan = findLoan(bookId);
				return true;
			}
			catch (LoanNotFoundException e) {
				return false;
			}
		}
}
