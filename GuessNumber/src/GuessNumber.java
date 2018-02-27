import javax.swing.JOptionPane;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double averageGuesses = 0;
		double totalNumberOfGuesses = 0;
		int numberOfGames = 0;
		
		String playAgainString; 
		
		do {
			
			// Creates input dialog box 
			String myStringNumber = JOptionPane.showInputDialog("Guess a number between 1 and 100!");
			System.out.println(myStringNumber);
			
			int numberOfGuesses = 1;
			
			// Make your random number to an integer
			int myNumber = Integer.parseInt(myStringNumber);
			System.out.println(myNumber);
			
			// Generate a random number
			double random = Math.random();
			random = random*100; 
			int randomInteger = (int) random;
			
			System.out.println(random);		
			System.out.println(randomInteger);
			
			//Check if random integer 0
			if (randomInteger == 0) randomInteger = 1;
			
			do {
				if (myNumber > randomInteger) {
					System.out.println("Your guess is too high!");
					myStringNumber = JOptionPane.showInputDialog("Guess a number between 1 and 100!");
					System.out.println(myStringNumber);
					myNumber = Integer.parseInt(myStringNumber);
					System.out.println(myNumber);
				}
				else if (myNumber < randomInteger) {
					System.out.println("your guess is too low!");
					myStringNumber = JOptionPane.showInputDialog("Guess a number between 1 and 100!");
					System.out.println(myStringNumber);
					myNumber = Integer.parseInt(myStringNumber);
					System.out.println(myNumber);
				};	
				numberOfGuesses++;
			}	while (myNumber != (int) randomInteger);
		
			if (myNumber == randomInteger) {
			System.out.println("Congratulation you guessed the correct number!");
			System.out.println("It took" + " " + numberOfGuesses + " " + "guesses");
			numberOfGames++;
			totalNumberOfGuesses = totalNumberOfGuesses + numberOfGuesses; 
			}
						
			playAgainString = JOptionPane.showInputDialog("Do you want to play again <yes/no>?");
			
		} while (playAgainString.equals("yes"));
		
		
			averageGuesses = totalNumberOfGuesses/numberOfGames;
			System.out.println("Average number of guesses are" + " " + averageGuesses);
			System.out.println("Welcome back!");
	}		
}	
