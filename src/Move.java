public class Move {
  private int x;
  private int y;

  public Move(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Move)) {
      return false;
    } else {
      return x == ((Move) o).getX() && y == ((Move) o).getY();
    }
  }

  @Override
  public int hashCode() {
    return x + y;
  }
  //do we need set methods
}