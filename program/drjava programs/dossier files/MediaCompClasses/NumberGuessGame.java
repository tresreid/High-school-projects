import java.util.*;

public class NumberGuessGame
{

  // fields
  private int targetNumber;
  private int lastGuess;
  private int totGuesses;
  
  // constructor
  public NumberGuessGame()
  {
    Random rng = new Random();
    this.targetNumber = rng.nextInt(100)+1;
    this.lastGuess = 0;
    this.totGuesses = 0;
  }
  
  //////////////////////////////////////////////////////
  // methods
  //
  
  public boolean checkGuess(int guess)
  {
    this.totGuesses++;
    this.lastGuess = guess;
    if (guess == this.targetNumber)
      return true;
    else
      return false;
  }
  
  public int getTotalGuesses()
  {
    return this.totGuesses;
  }
  
  public int getTargetNumber()
  {
    return this.targetNumber;
  }
  
  public boolean isTargetHigher()
  {
    if (this.targetNumber > this.lastGuess)
      return true;
    else
      return false;
  }
  
  public static void main(String[] args)
  {
    NumberGuessGame game = null;
    int guess = 0;
    String prompt = null;
    
    String yesNo = SimpleInput.getString("Would you like to play a game?");
    while (yesNo.equals("yes"))
    {
      game = new NumberGuessGame();
      
      boolean guessedRight = false;
      while (!guessedRight) {
        if (game.getTotalGuesses() > 20)
        {
          prompt = "Guess a number between 1 and 100, inclusive [Hint: it's between " +
            (game.getTargetNumber() - 5) + " and " + (game.getTargetNumber() + 5) + "]";
        }
        else
        {
          prompt = "Guess a number between 1 and 100 (inclusive):";
        }
        guess = SimpleInput.getIntNumber(prompt, 1, 100);
        guessedRight = game.checkGuess(guess);
        if (!guessedRight) {
          if (game.isTargetHigher())
            prompt = "The number is higher than your last guess.";
          else
            prompt = "The number is lower than your last guess.";
          SimpleOutput.showInformation("Sorry, but that's not the number. " + prompt);
        }
      }
      
      SimpleOutput.showInformation("Congratulations!  You guessed the number.  It only took you " + game.getTotalGuesses() +
                   " guesses.");
      
      yesNo = SimpleInput.getString("Would you like to play again?");
    }
    
  }
  
} // end of NumberGuessGame class