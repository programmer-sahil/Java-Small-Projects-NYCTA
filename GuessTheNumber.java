import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Create a random number between 1 and 100
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        
        int userGuess = 0;
        int numberOfTries = 0;
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        // Loop until the correct guess
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            numberOfTries++;
            
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + numberOfTries + " tries.");
            }
        }

        scanner.close();
    }
}
