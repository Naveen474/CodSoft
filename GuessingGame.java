import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            int numberToGuess = random.nextInt(100) + 1;  // Generate random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7;
            System.out.println("Round " + rounds + " has started! You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                attempts++;
                System.out.print("Enter your guess (between 1 and 100): ");
                int guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess is out of bounds. Please choose a number between 1 and 100.");
                    attempts--;
                    continue;
                }

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += maxAttempts - attempts + 1;  // Score based on remaining attempts
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Game over! You played " + rounds + " round(s) and your total score is " + totalScore + ".");
        scanner.close();
    }
}