
public class Paper {
  private final int width;
  private final int height;
  private char[][] plane;

  public Paper(int width, int height) {
    assert (width > 2) && (height > 2) : "not large enough";
    this.width = width;
    this.height = height;
    this.initialisePaper();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  private void initialisePaper() {
    plane = new char[height*2 - 1][width*2 - 1];
    for(int y = 0; y < height*2 - 1; y++) {
      for(int x = 0; x < width*2 - 1; x++) {
        if(y % 2 == 0 && x % 2 == 0) {
          plane[y][x] = 'o';
        } else {
          plane[y][x] = ' ';
        }
      }
    }
  }

  public void printPaper() {
    String output = "";
    for(int y = 0; y < height*2 - 1; y++) {
      for(int x = 0; x < width*2 - 1; x++) {
        output += plane[y][x];
      }
      output += '\n';
    }
    System.out.println(output);
  }

  public void makeMark(char c, int x, int y) {
    plane[y*2 - 1][x*2 - 1] = c;
  }

  public boolean isCorner(int x, int y) {
    return plane[y*2 - 1][x*2 - 1] == 'o';
  }

  public boolean isMark(char c, int x, int y) {
    return plane[y][x] == c;
  }

  public boolean needsToBeFilled(char c, int x, int y) {
    assert ()
  }

  public void fillIn() {
    for (int y = 1; y < height*(2 - 1); y++) { //may as well start from 1
      for (int x = 1; x < width*(2 - 1); x++) {
        if ()
      }
    }
  }

  public boolean isFinished() {

  }
  public static void main(String[] args) {
    Paper paper = new Paper(3, 3);

  }

}
