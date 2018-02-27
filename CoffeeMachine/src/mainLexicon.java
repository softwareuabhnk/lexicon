
public class mainLexicon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeeMaker irish = new CoffeeMaker(true, "Liljeholmen", CoffeeType.IRISH);
		CoffeeMaker expresso = new CoffeeMaker(true, "Hornstull", CoffeeType.EXPRESSO);
		
		System.out.println("Coffee Machine name:" + irish.getName());
		irish.serveCoffee(3);
		irish.serveCoffee(2);
		System.out.println("Number of cups for this machine:" + irish.getNumberOfServedCups());
		irish.serveCoffee(1);
		expresso.serveCoffee(2);
		System.out.println("Number of cups for this machine:" + expresso.getNumberOfServedCups());
		
		System.out.println("Total number of cups for all machines:" + irish.getNumberOfServedCupsTotal());
		System.out.println("Total number of cups for all machines:" + expresso.getNumberOfServedCupsTotal());
		System.out.println("Total number of cups for all machines:" + CoffeeMaker.getNumberOfServedCupsTotal());

	}
}
