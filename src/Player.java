import java.util.*;

public class Player {
  private final String name;
  private final Colour colour;
  private int score = 0;

  public Player(String name, Colour colour) {
    this.name = name;
    this.colour = colour;
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