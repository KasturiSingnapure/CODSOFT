import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String play = "yes";
		int roundsWon = 0;
		int totalAttempts = 0;
		int maxAttempts = 10;

		while (play.equals("yes")) {
			Random rand = new Random();
			int randNum = rand.nextInt(100) + 1; // To generate numbers between 1 and 100
			int guess = -1;
			int tries = 0;
			boolean won = false;

			System.out.println("New round started! You have " + maxAttempts + " attempts to guess the number.");

			while (tries < maxAttempts) {
				System.out.print("Guess the number between 1 and 100: ");
				guess = reader.nextInt();
				tries++;
				totalAttempts++;

				if (guess == randNum) {
					System.out.println("Great! You guessed the number!");
					System.out.println("It only took you " + tries + " guesses!");
					roundsWon++;
					won = true;
					break;
				} else if (guess > randNum) {
					System.out.println("Your guess is too high, try again.");
				} else {
					System.out.println("Your guess is too low, try again.");
				}
			}

			if (!won) {
				System.out.println("Sorry, you've used all your attempts. The correct number was: " + randNum);
			}

			System.out.print("Would you like to play again? Yes or No: ");
			play = reader.next().toLowerCase();
		}

		System.out.println("Game over! You won " + roundsWon + " rounds.");
		System.out.println("Total attempts made: " + totalAttempts);
		reader.close();
	}
}
