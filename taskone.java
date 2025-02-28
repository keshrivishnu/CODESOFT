import java.util.Random;
import java.util.Scanner;

public class taskone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; // Generates random number from 1 to 100
            int attempts = 0;
            int maxAttempts = 7; // Limit the number of attempts

            System.out.println("Guess the number between 1 and 100!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++; // Increment score for correct guess
                    break; // Exit the loop
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("You ran out of attempts. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Your final score is: " + score);
        scanner.close();
    }
}
