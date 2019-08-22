import java.util.Scanner;

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
    plane[y][x] = c;
  }

  public boolean isCorner(int x, int y) {
    return plane[y][x] == 'o';
  }

  public boolean isBlank(int x, int y) {
    return plane[y][x] == ' ';
  }

  public boolean needsToBeFilled(int x, int y) {
    //need to write an assert comment here
    return plane[y][x - 1] != ' ' && plane[y][x + 1] != ' ' && plane[y - 1][x] != ' ' && plane[y + 1][x] != ' ';

  }

  public void fillIn(char c) {
    for (int y = 1; y < height*(2 - 1); y = y + 2) { //may as well start from 1
      for (int x = 1; x < width*(2 - 1); x = x + 2) {
        if (needsToBeFilled(x, y)) {
          makeMark(c, x, y);
        }
      }
    }
  }

  public boolean isFinished() {
    for (int y = 1; y < height*(2 - 1); y = y + 2) { //may as well start from 1
      for (int x = 1; x < width * (2 - 1); x = x + 2) {
        if (plane[y][x] == ' '){
          return false;
        }
      }
    }
    return true;
  }

  public boolean isMiddle(int x, int y) {
    return x % 2 == 1 && y % 2 == 1; //depends if you index beginning from 1 or 0
  }

  public static void main(String[] args) {
    Paper paper = new Paper(3, 3);
    Scanner input = new Scanner(System.in);
    int x = 0;
    int y = 0;
    while(!paper.isFinished()) {
      while (paper.isCorner(x, y) || !paper.isBlank(x, y) || paper.isMiddle(x, y)) { //if both even then it is a corner
        System.out.println("X: ");
        x = Integer.parseInt(input.nextLine());
        System.out.println("Y: ");
        y = Integer.parseInt(input.nextLine());
      }
      paper.makeMark('B', x, y);
      paper.fillIn('B');
      paper.printPaper();
    }

  } // this cycle works

}
