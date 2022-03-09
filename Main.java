/* File Name: Main.java
Entire Code By: Noah Brown, Kayla Holmes, Kevin Tolbert, Jeremiah Whitehurst, and Jeff Zheng */

// Import Scanner Utility
import java.util.*;

class Main {
	public static void main(String[] args) {
		// Scanner object will be 'n', WordBank object will be 'f', HangmanDraw object will be 'g'
		Scanner n = new Scanner(System.in);
		WordBank f = new WordBank();
		HangmanDraw g = new HangmanDraw();
		// Has its value assigned depending on the category number (starting from index 0)
		int category = 0;
		// The random word used in the program
		String randomWord = "";
    String userCat = "";
    String buff = "";

		// GET THE USER TO TYPE 'START'
		System.out.println("\n\nWelcome to hangman! You will have three attempts before you fail the game. Enter " + g.ANSI_BLUE + "START" + g.ANSI_RESET + " to begin the game!");
		String inputStart = n.nextLine();
		System.out.println("\n");
		/* If the user enters 'START', then they will be asked to choose a category.
		Depending on the category, a random word from it wil be chosen using Math.random() */
		if (inputStart.equalsIgnoreCase("START")) {
			System.out.println("Enter one of the following categories: " + g.ANSI_CYAN + "Trees" + g.ANSI_RESET + ", " + g.ANSI_CYAN + "Colors" + g.ANSI_RESET + ", " + g.ANSI_CYAN + "Animals" + g.ANSI_RESET + ", " + g.ANSI_CYAN + "Food" + g.ANSI_RESET + ", " + g.ANSI_CYAN + "Global Cities" + g.ANSI_RESET);
			userCat = n.nextLine();
      // displayHint
			for (int i = 0; i < f.bankArrayCat.length; i++) {
				if (userCat.equalsIgnoreCase(f.bankArrayCat[i])) {
					category = i;
					randomWord = f.bankArray[category][(int) (Math.random() * f.bankArray.length)];
					break;
				}
			}
		} else {
			System.exit(0);
		}

		// Arrays that will contain the correct letters entered by the user (uLetters) and incorrectly guessed letters
		char[] uLetters = new char[randomWord.length()];
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
		/* Arrays fill did not want to work with me ;-;
		Filling the entire uLetters array with underscores */
		for (int i = 0; i < uLetters.length; i++) {
			uLetters[i] = '_';
		}
		// Clears console
		System.out.print("\033[H\033[2J");
    System.out.flush();

		// Total number of wrong guesses
		int numWGuess = 0;

		// Where the program starts
		while (numWGuess < 3) {
			// Boolean values for if input was correct and if the game is finished
			boolean correctGuess = false;
			boolean finishGame = true;
      System.out.println(g.ANSI_YELLOW + "\nCategory: " + g.ANSI_RESET + userCat);
      hangmanPhases(g, numWGuess);
      currentGuesses(randomWord, uLetters);
      displayHint(f, g, randomWord, category);


      System.out.println("\nWould you like to guess a letter (L) or guess the word (W)?");
      String choice = Character.toString(n.next().charAt(0));
      if (choice.equalsIgnoreCase("l"))
      {
        // Beginning of the hangman game (including asking for input)
        System.out.println("\nWrong Letter Bank: " + guessedLetters);
        hangmanStart(n, g);
			  char input = n.next().charAt(0);
        // Checks for if the input is equal to a character in the random word
			  for (int i = 0; i < randomWord.length(); i++) {
				  char letter = randomWord.charAt(i);
				  if (input == letter) {
					  uLetters[i] = input;
					  correctGuess = true;
				  }
			  }
        if (correctGuess)
        {
          System.out.println(g.ANSI_GREEN + "< Correct! >" + g.ANSI_RESET);
        }
			  // Checks if correctGuess is false
			  if (!correctGuess) {
          guessedLetters.add(input);
				  numWGuess++;
				  System.out.println(g.ANSI_RED + "< Wrong... >" + g.ANSI_RESET);
			  }
			  // Prints hangman and number of incorrect guesses.
			  System.out.print("\nNumber of incorrect guesses: " + numWGuess);

			  // Checks if there are empty spaces in the guess
			  for (int i = 0; i < randomWord.length(); i++) {
				  if (uLetters[i] == '_') {
					  finishGame = false;
				  }
			  }

			  // User loses if the number of wrong guesses equals 3
			  if (numWGuess == 3) {
          hangmanPhases(g, numWGuess);
				  System.out.println(g.ANSI_RED + "\nYou lost." + g.ANSI_RESET);
				  System.out.println("The word was: " + g.ANSI_UNDERLINE + g.ANSI_YELLOW + randomWord + g.ANSI_RESET);
				  break;
			  }
			  // User wins if the finishGame boolean is true
			  if (finishGame) {
			  	System.out.println(g.ANSI_GREEN + "You beat the game!" + g.ANSI_RESET);
				  break;
			  }
      }
      if (choice.equalsIgnoreCase("w")) {
        buff = n.nextLine();
        hangmanStart(n, g);
        String input = n.nextLine();
        guessTheWord(randomWord, input, uLetters, g);
        break;
      }
		}
	}

	// Method to get current guesses
	public static void currentGuesses(String randomWord, char uLetters[]) {
		System.out.print("\nCurrent Guesses: ");
		for (int i = 0; i < randomWord.length(); i++) {
			System.out.print(uLetters[i]);
		}
		System.out.println();
	}

	// Method to start/continue the hangman game
	public static void hangmanStart(Scanner n, HangmanDraw g) {
		System.out.print("\nEnter " + g.ANSI_BLUE + "input: " + g.ANSI_RESET);
	}
	// Method to display hangman phases
  public static void hangmanPhases (HangmanDraw g, int wrongCount)
  {
    if (wrongCount == 1)
    {
      g.hangman1(g.ANSI_GREEN);
    }
    if (wrongCount == 2)
    {
      g.hangman2(g.ANSI_YELLOW);
    }
    if (wrongCount == 3)
    {
      g.hangman3(g.ANSI_RED);
    }
    if (wrongCount == 0)
    {
      g.hangman0();
    }
  }

  // method to check if the user, upon choosing to guess the full word rather than type every letter, correctly guesses the word
  public static void guessTheWord (String randomWord, String guess, char[] uLetters, HangmanDraw g)
  {
    int wordLength = randomWord.length();
    int letterCount = 0;
    // checks if input matches word length to avoid string index out of bounds exception
    if (randomWord.length() != guess.length())
    {
      System.out.println();
    }
    // word checker
    else
    {
      for (int i = 0; i < wordLength; i++) {
        char input = guess.charAt(i);
			  char letter = randomWord.charAt(i);
			  if (input == letter) {
				  uLetters[i] = input;
				  letterCount++;
			  }
		  }
    }

    // if correct word
    if (wordLength == letterCount)
    {
      System.out.println(g.ANSI_GREEN + "You guessed the word! You beat the game!" + g.ANSI_RESET);
    }
    // if wrong word
    else
    {
      System.out.println(g.ANSI_RED + "\nThat was not the word." + g.ANSI_RESET);
			System.out.println("The word was: " + g.ANSI_UNDERLINE + g.ANSI_YELLOW + randomWord + g.ANSI_RESET);
    }
  }

  // allows hint to be redisplayed whenever
  public static void displayHint (WordBank f, HangmanDraw g, String randomWord, int category)
  {
		for (int i = 0; i < 5; i++) {
			if (randomWord.equals(f.bankArray[category][i])) 
      {
				System.out.println(g.ANSI_PURPLE + "v HINT v" + g.ANSI_RESET);
				System.out.println(f.bankArrayHints[category][i]);
			}
    }
  }
}