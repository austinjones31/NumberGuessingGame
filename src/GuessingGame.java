import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessingGame {

  public static void main(String[] args) {
    Random random = new Random();
    int computerNumber = random.nextInt(10) + 1;
    UserInput userInput = new UserInput();
    boolean correctGuess;
    do {
      userInput.readInput();
      int userGuess = userInput.getGuess();
      correctGuess = new NumberMatch(computerNumber, userGuess).evaluateGuess();
    } while (!correctGuess);
  }
}

class UserInput {

  String guessInput;
  int guess;
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

  public void readInput() {
    System.out.println("Guess a number between 1 and 10.");
    try {
      this.guessInput = this.input.readLine();
      this.guess = Integer.parseInt(this.guessInput);
      assert this.guess < 11 && this.guess > 0;
    } catch (IOException | NumberFormatException | AssertionError e) {
      System.out.println("That is not an integer between 1 and 10.");
      readInput();
    }
  }

  public int getGuess() {
    return this.guess;
  }
}

class NumberMatch {

  int computerNumber;
  int userGuess;

  NumberMatch(int computerNumber, int userGuess) {
    this.computerNumber = computerNumber;
    this.userGuess = userGuess;
  }

  public boolean evaluateGuess() {
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
