package mod3.exercise6;

public class GameOverException extends Exception {
    private int numberOftries;

    public GameOverException(int numberOftries) {
      super("Game over! You used all "  + numberOftries + " tries.");
    }
}
