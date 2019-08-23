import java.util.Scanner;

public class main {
  public static void main(String argc[]) {
    Scanner input = new Scanner(System.in);

    //player 1
    System.out.println("Player Number 1 name: ");
    String player1Name = input.nextLine();
    String colour1 = " ";
    while (!colour1.equals("red") && !colour1.equals("blue")) {
      System.out.println("Player Number 1 colour: ");
      colour1 = input.nextLine();
    }

    //player 2
    System.out.println("Player Number 2 name: ");
    String player2Name = input.nextLine();
    String colour2 = " ";
    while ((!colour2.equals("red") && !colour2.equals("blue")) || colour2.equals(colour1)) {
      System.out.println("Player Number 2 colour: ");
      colour2 = input.nextLine();
    }

    //making player objects
    Player player1;
    Player player2;
    if (colour1.equals("red")) {
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

    Game game = new Game(player1, player2, paper);
    game.runGame();

  }
}