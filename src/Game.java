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

  public void runODPTGame() {
    Scanner input = new Scanner(System.in);

    System.out.println("\nInitial Grid: ");
    paper.printPaper();

    //turns begin
    Player whoseTurn = player1;
    int howManyFilledIn = 0;

    while(!paper.isFinished()) {
      Move move;
      System.out.println(player1.getName() + ": " + player1.getScore() + " " + player2.getName() + ": " + player2.getScore());
      System.out.println(whoseTurn.getName() + "'s Turn");
      move = whoseTurn.takeTurn(this.paper);
      char c = whoseTurn.getMark();

      paper.makeMark(c, move.getX(), move.getY());
      howManyFilledIn = paper.fillIn(c);
      for (int i = 0; i < howManyFilledIn; i++) {
        whoseTurn.scored();
      }

      if (whoseTurn == player1) {
        whoseTurn = player2;
      } else {
        whoseTurn = player1;
      }

      paper.printPaper();
    }

    System.out.println("GAME IS FINISHED");
    System.out.println(this.whoWon().getName() + " has Won!");
  }

  public void runCTGame() {
    Scanner input = new Scanner(System.in);

    System.out.println("\nInitial Grid: ");
    paper.printPaper();

    //turns begin
    int howManyFilledIn = 0;
    Player whoseTurn = player1;

    while(!paper.isFinished()) {
      Move move;
      System.out.println(player1.getName() + ": " + player1.getScore() + " " + player2.getName() + ": " + player2.getScore());
      System.out.println(whoseTurn.getName() + "'s Turn");
      move = whoseTurn.takeTurn(this.paper);
      char c = whoseTurn.getMark();

      paper.makeMark(c, move.getX(), move.getY());
      howManyFilledIn = paper.fillIn(c);
      for (int i = 0; i < howManyFilledIn; i++) {
        whoseTurn.scored();
      }
      if(howManyFilledIn == 0) {
        if (whoseTurn == player1) {
          whoseTurn = player2;
        } else {
          whoseTurn = player1;
        }
      }
      paper.printPaper();
    }

    System.out.println("GAME IS FINISHED");
    System.out.println(this.whoWon().getName() + " has Won!");

  }

}
