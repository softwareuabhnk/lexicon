
public class CoffeeMaker {
	private boolean power;
	private String name;
	private CoffeeType coffeeType;
	
	private static final int MAX_LIMIT_CUPS = 5;
	private int numberOfServedCups;
	// static 
	private static int numberOfServedCupsTotalForAllMachines;
	
	public CoffeeMaker(boolean power, String name, CoffeeType coffeeType) {
		//super();
		this.power = power;
		this.name = name;
		this.coffeeType = coffeeType;
	}

	public void serveCoffee(int numberOfCups) {
		boolean power = false; 
		if (((numberOfCups + numberOfServedCups) <= MAX_LIMIT_CUPS) && (this.power == true)) {
			this.numberOfServedCups += numberOfCups;
			this.numberOfServedCupsTotalForAllMachines += numberOfCups;
			System.out.println("Served " + numberOfCups + " " + this.coffeeType);
		}
		else {
			
			if (this.power == true) {
				System.out.println("Limit for this machine is reached");
				refillAndReset();
				}
			}	
	}		
	
	public void refillAndReset() {
		System.out.println("Machine is now refilled and reset");
		this.numberOfServedCups = 0;
	}
	
	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CoffeeType getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(CoffeeType coffeeType) {
		this.coffeeType = coffeeType;
	}

	public int getNumberOfServedCups() {
		return numberOfServedCups;
	}

	public static int getNumberOfServedCupsTotal() {
		return numberOfServedCupsTotalForAllMachines;
	} 
	
	

}
