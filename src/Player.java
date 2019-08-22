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