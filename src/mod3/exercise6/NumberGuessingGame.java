package mod3.exercise6;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    Random rand = new Random();
    int secretNumber = rand.nextInt(20);
    int wrongGuesses = 0;
    Scanner scanner = new Scanner(System.in);

    public void guessNumber() throws GameOverException {
        while(wrongGuesses < 7) {
                try {
                    System.out.println("Please enter a number: ");
                    int number = Integer.parseInt(scanner.nextLine());

                    if (number > secretNumber) {
                        System.out.println("Number too high, go lower!");
                    } else if (number < secretNumber) {
                        System.out.println("Number too low, go higher");
                    } else {
                        System.out.println("\n ********** Congratulations! **********");
                        System.out.println("\n You guessed the number! The number is: " + secretNumber + "!");
                        return;
                    }

                    if (number != secretNumber) {
                        wrongGuesses++;
                        System.out.println("Wrong guess! You have " + (7 - wrongGuesses) + " left!");
                        if (wrongGuesses == 7) {
                                throw new GameOverException(7);
                        }
                    }
                }   catch (NumberFormatException e){
                    System.out.println("Please enter a valid number!");
            }
        }
    }
}
