class HangmanDraw {
	public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_PURPLE = "\033[0;35m";
	public static final String ANSI_UNDERLINE = "\u001B[4m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void hangman0()
  {
    System.out.println("  |--|");
    System.out.println("     |");
    System.out.println("     |");
    System.out.println("     |");
    System.out.println("     |");
    System.out.println("    _|_");
  }

	public static void hangman1(String ANSI_GREEN) {
		System.out.println(ANSI_GREEN);
    System.out.println("  |--|");
    System.out.println("  O  |");
    System.out.println("     |");
    System.out.println("     |");
    System.out.println("     |");
    System.out.println("    _|_");
    System.out.println(ANSI_RESET);
	}
	public static void hangman2(String ANSI_YELLOW) {
		System.out.println(ANSI_YELLOW);
    System.out.println("  |--|");
    System.out.println("  O  |");
    System.out.println(" \\|/ |");
    System.out.println("     |");
    System.out.println("     |");
    System.out.println("    _|_");	
    System.out.println(ANSI_RESET);
	}
	public static void hangman3(String ANSI_RED) {
		System.out.println(ANSI_RED);
    System.out.println("  |--|");
    System.out.println("  O  |");
    System.out.println(" \\|/ |");
    System.out.println("  |  |");
    System.out.println(" / \\ |");
    System.out.println("    _|_");
    System.out.println(ANSI_RESET);
	}
}