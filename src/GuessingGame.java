import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessingGame {

  public static void main(String[] args) {
    Random random = new Random();
    int computerNumber = random.nextInt(10) + 1;
    UserInput userInput = new UserInput();
    boolean guessIsCorrect;
    do {
      userInput.readInput();
      int userGuess = userInput.getUserGuess();
      guessIsCorrect = new NumberMatcher(computerNumber, userGuess).isMatch();
    } while (!guessIsCorrect);
  }
}

class UserInput {

  int userGuess;
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

  public void readInput() {
    System.out.println("Guess a number between 1 and 10.");
    try {
      this.userGuess = Integer.parseInt(this.input.readLine());
      assert this.userGuess < 11 && this.userGuess > 0;
    } catch (IOException | NumberFormatException | AssertionError e) {
      System.out.print("That is not an integer between 1 and 10. ");
      readInput();
    }
  }

  public int getUserGuess() {
    return this.userGuess;
  }
}

class NumberMatcher {

  int computerNumber;
  int userGuess;

  NumberMatcher(int computerNumber, int userGuess) {
    this.computerNumber = computerNumber;
    this.userGuess = userGuess;
  }

  public boolean isMatch() {
    if (this.userGuess == this.computerNumber) {
      System.out.println(
        "You got it! The number is " + this.computerNumber + "."
      );
      return true;
    } else if (this.userGuess > this.computerNumber) {
      System.out.println("Guess is too high!");
    } else {
      System.out.println("Guess is too low!");
    }
    return false;
  }
}
