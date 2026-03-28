package exercise6;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
    NumberGuessingGame game1 = new NumberGuessingGame();

    try {
        game1.guessNumber();
    } catch (GameOverException e){
        System.out.println(e.getMessage());
    }

    }
}

