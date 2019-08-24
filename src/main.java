import java.util.Scanner;

public class main {

  public static void personVsPerson(String rules) {
    Scanner input = new Scanner(System.in);
    //player 1
    System.out.println("Player Number 1 name: ");
    String player1Name = input.nextLine();
    String colour1 = " ";
    while (!utils.isColour(colour1)) {
      System.out.println("Player Number 1 colour: ");
      colour1 = input.nextLine();
    }

    //player 2
    System.out.println("Player Number 2 name: ");
    String player2Name = input.nextLine();
    String colour2 = " ";
    while (!utils.isColour(colour2) || colour2.equals(colour1)) {
      System.out.println("Player Number 2 colour: ");
      colour2 = input.nextLine();
    }

    //making player objects
    Player player1;
    Player player2;
    if (utils.isRed(colour1)) {
      player1 = new Player(player1Name, Colour.RED);
      player2 = new Player(player2Name, Colour.BLUE);
    } else {
      player1 = new Player(player1Name, Colour.BLUE);
      player2 = new Player(player2Name, Colour.RED);
    }

    //making paper
    int width = 0;
    int height = 0;

    while (width < 3 || height < 3) {
      System.out.println("What is the height");
      height = Integer.parseInt(input.nextLine());
      System.out.println("What is the width");
      width = Integer.parseInt(input.nextLine());
    }

    //create paper object and print original grid
    Paper paper = new Paper(width, height);

    Game game = new Game(player1, player2, paper, getRuleType(rules));
    game.runGame();
  }

  public static void personVsAI(String rules) {
    Scanner input = new Scanner(System.in);

    //player 1
    System.out.println("Player Number 1 name: ");
    String player1Name = input.nextLine();
    String colour1 = " ";
    while (!utils.isColour(colour1)) {
      System.out.println("Player Number 1 colour: ");
      colour1 = input.nextLine();
    }

    Player player1;
    Player player2;
    if(utils.isRed(colour1)){
      player1 = new Player(player1Name, Colour.RED);
      player2 = new Player(Colour.BLUE);
    } else {
      player1 = new Player(player1Name, Colour.BLUE);
      player2 = new Player(Colour.RED);

    }

    //making paper
    int width = 0;
    int height = 0;

    while (width < 3 || height < 3) {
      System.out.println("What is the height");
      height = Integer.parseInt(input.nextLine());
      System.out.println("What is the width");
      width = Integer.parseInt(input.nextLine());
    }

    //create paper object and print original grid
    Paper paper = new Paper(width, height);

    Game game = new Game(player1, player2, paper, getRuleType(rules));
    game.runGame();

  }

  public static Rules getRuleType(String str) {
    if (str.equals("CT")) {
      return Rules.CT;
    } else if (str.equals("ODPT")) {
      return Rules.ODPT;
    } else {
      return null;
    }
  }

  public static void main(String argc[]) {
    Scanner input = new Scanner(System.in);
    String gameMode = " ";
    String rules = " ";
    while (!gameMode.equals("1") && !gameMode.equals("2") && !rules.equals("ODPT") && !rules.equals("CT")) {
      System.out.println("1. Player vs Player \n2. Player Vs AI \n");
      gameMode = input.nextLine();
      System.out.println("Rules : \nOne move per turn (ODPT) \nContinuous turn if win a square (CT)");
      rules = input.nextLine();
    }
    if (rules.equals("ODPT")) {
      if (gameMode.equals("1")) {
        personVsPerson(rules);
      } else {
        personVsAI(rules);
      }
    } else if (rules.equals("CT")) {
      if (gameMode.equals("1")) {
        personVsPerson(rules);
      } else {
        personVsAI(rules);
      }
    }

  }

}