package lendinglib.models;

public class DVD extends Material {
	private String director;
	private String catalogNo;
	private int runningTime;
	private boolean licensed; //False
	
	public DVD(String id, String title, String branch, String director, 
			String catalogNo, int runningTime) {
		super(id, title, branch);
		this.director = director;
		this.catalogNo = catalogNo;
		this.runningTime = runningTime;
		licensed = false;
	}
	
	public void licence() {
		licensed = true;
	}
	
	public boolean getLicence() {
		return licensed;
	}
	
	public String getDirector() {
		return director;
	}

	public boolean lend(Customer customer) {
		if (licensed) {
			return super.lend(customer);
		} else {
			return false;
		}
	}
	
	public int getLoanPeriod() {
		return 7;
	}
	
	public int getRunningTime() {
		return runningTime;
	}
	
	public String getCatalogNumber() {
		return catalogNo;
	}
	
	
	@Override
	public String toString() {
		return "DVD: " + getID() + " " + getTitle() + " " + getDirector();
	}
}
	
	