import java.util.*;

public class Player {
  private final String name;
  private final Colour colour;
  private int score = 0;
  private boolean AI;

  public Player(String name, Colour colour) {
    this.name = name;
    this.colour = colour;
    this.AI = false;
  }

  public Player(Colour colour) {
    this.name = "AI";
    this.colour = colour;
    this.AI = true;
  }

  public String getName() {
    return name;
  }

  public Colour getColour() {
    return colour;
  }

  public int getScore() {
    return score;
  }

  public Move takeTurn(Paper paper) {
    if (AI) {
      DecisionTree dt2 = new DecisionTree(paper);
      dt2.makeDecisionTree();
      return dt2.getBestMove();
    } else {
      Scanner input = new Scanner(System.in);
      int x = 0;
      int y = 0;
      while (paper.isCorner(x, y) || !paper.isBlank(x, y) || paper.isMiddle(x, y)) { //if both even then it is a corner
        System.out.println("X: ");
        x = Integer.parseInt(input.nextLine());
        System.out.println("Y: ");
        y = Integer.parseInt(input.nextLine());
      }
      return new Move(x, y);
    }
  }

  public void scored() {
    score++;
  }

  public char getMark() {
    if (colour == Colour.RED) {
      return 'R';
    } else if (colour == Colour.BLUE){
      return 'B';
    } else {
      return 'X';
    }
  }

}