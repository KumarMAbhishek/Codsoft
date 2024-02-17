package program_1;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();
        boolean playAgain = true;
        int score = 0;
        int rounds = 0;

        while (playAgain) {
            int randomNumber = ra.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to Number Guessing Game!!");
            while (!guessedCorrectly && attempts < 5) {
                System.out.println("Enter A Guess Number (Range from 1 to 100): ");
                int guessNumber = sc.nextInt();
                attempts++;
                if (guessNumber == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                    score += (6 - attempts);
                    guessedCorrectly = true;
                } else if (guessNumber < randomNumber) {
                    System.out.println("Too Low for the guess number!!");
                    System.out.println("Attempts left: " + (6 - attempts));
                } else if (guessNumber > randomNumber) {
                    System.out.println("Too High for the guess number!!");
                    System.out.println("Attempts left: " + (6 - attempts));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            }

            rounds++;
            System.out.println("Your current score: " + score);
            System.out.println("Number of rounds played: " + rounds);

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = sc.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing!");
        sc.close();
    }
}
