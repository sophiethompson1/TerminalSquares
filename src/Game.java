import java.util.Scanner;

public class Game {
  private Player player1;
  private Player player2;
  private Paper paper;

  public Game(Player player1, Player player2, Paper paper) {
    this.player1 = player1;
    this.player2 = player2;
    this.paper = paper;
  }

  public Game(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.paper = new Paper(4, 4);
  }

  public Game(Player player1) {
    this.player1 = player1;
    this.player2 =
  }

  public Paper getPaper() {
    return paper;
  }

  public Player getPlayer1() {
    return player1;
  }

  public Player getPlayer2() {
    return player2;
  }

  public Player whoWon() {
    char winner = paper.charWon();
    if (winner == player1.getMark()) {
      return player1;
    } else {
      return player2;
    }
  }

  public void runNormalGame() {
    Scanner input = new Scanner(System.in);

    System.out.println("\nInitial Grid: ");
    paper.printPaper();

    //turns begin
    int x = 0;
    int y = 0;
    int count = 0;
    int howManyFilledIn = 0;

    while(!paper.isFinished()) {
      Move move;
      System.out.println(player1.getName() + ": " + player1.getScore() + " " + player2.getName() + ": " + player2.getScore());
      if (count % 2 == 0) {
        System.out.println(player1.getName() + "'s Turn");
        move = player1.takeTurn();
      } else {
        System.out.println(player2.getName() + "'s Turn");
        move = player2.takeTurn();
      }

      char c = ' ';
      if (count % 2 == 0) {
        c = player1.getMark();
      } else {
        c = player2.getMark();
      }
      paper.makeMark(c, x, y);
      howManyFilledIn = paper.fillIn(c);
      for (int i = 0; i < howManyFilledIn; i++) {
        if (count % 2 == 0) {
          player1.scored();
        } else {
          player2.scored();
        }
      }
      paper.printPaper();
      count++;
    }

    System.out.println("GAME IS FINISHED");
    System.out.println(this.whoWon().getName() + "has Won!");

  }

}
