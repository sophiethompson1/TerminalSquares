import java.util.Scanner;

public class Paper {
  private final int width;
  private final int height;
  private char[][] plane;

  public Paper(int w, int h) {
    assert (w > 2) && (h > 2) : "not large enough";
    this.width = w*2 - 1;
    this.height = h*2 - 1;
    this.initialisePaper();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  private void initialisePaper() {
    plane = new char[height][width];
    for(int y = 0; y < height; y++) {
      for(int x = 0; x < width; x++) {
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
    for(int y = 0; y < height; y++) {
      for(int x = 0; x < width; x++) {
        output += plane[y][x];
        output += ' ';
      }
      output += '\n';
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

  public boolean isMiddle(int x, int y) {
    return x % 2 == 1 && y % 2 == 1; //depends if you index beginning from 1 or 0
  }

  public boolean isMarkable(int x, int y) {
    return isBlank(x, y) && !isCorner(x, y) && !isMiddle(x, y);
  }

  public boolean hasBeenMarked(int x, int y) {
    return !isBlank(x, y) && !isCorner(x, y) && !isMiddle(x, y);
  }

  public int madeAThree(int x, int y) { //returning how many threes that were ade
    int count = 0;
    if (x%2 == 1 && y%2 == 0) { //this is a sideways dash -
      //check square above and below
      //square above
      if (y > 1) { //wont have a square above it being careful of array access
        if (this.hasBeenMarked(x - 1, y - 1) && this.hasBeenMarked(x, y -2) && this.isMarkable(x + 1, y -1)) {
          count++;
        }
        if (this.hasBeenMarked(x, y - 2) && this.hasBeenMarked(x + 1, y -1) && this.isMarkable(x - 1, y -1)) {
          count++;
        }
        if (this.hasBeenMarked(x - 1, y -1) && this.hasBeenMarked( x +1, y - 1) && this.isMarkable(x, y -2)) {
          count++;
        }
      }
      //square below
      if (y < height - 1) { //dpesnt have a square below careful of array access
        if (this.hasBeenMarked(x -1 , y +1) && this.hasBeenMarked(x + 1, y +1) && this.isMarkable(x, y +2)) {
          count++;
        }
        if (this.hasBeenMarked(x -1, y +1) && this.hasBeenMarked(x, y + 2) && this.isMarkable(x + 1, y + 1)) {
          count++;
        }
        if (this.hasBeenMarked(x, y + 2) && this.hasBeenMarked(x + 1, y +1) && this.isMarkable(x -1, y +1)) {
          count++;
        }
      }
    } else if (x%2 == 0 && y %2 == 1) { //this is a dash like |
      //square to left and right
      //left of dahs
      if (x > 1) { //makes sure its not side array access
        if (this.hasBeenMarked(x -1, y -1) && this.hasBeenMarked(x -1, y + 1) && this.isMarkable(x -2, y)) {
          count++;
        }
        if (this.hasBeenMarked(x -1, y -1) && this.hasBeenMarked(x -2, y) && this.isMarkable(x -1, y + 1)) {
          count++;
        }
        if (this.hasBeenMarked(x -1, y+1) && this.hasBeenMarked(x -2 , y) && this.isMarkable(x -1, y - 1)) {
          count++;
        }
      }

      //right of it
      if (x < width - 1) {
        if (this.hasBeenMarked(x + 1, y -1) && this.hasBeenMarked(x + 1, y +1) && this.isMarkable(x + 2, y)) {
          count++;
        }
        if (this.hasBeenMarked( x + 1, y - 1) && this.hasBeenMarked( x + 2, y) && this.isMarkable(x + 1, y +1)) {
          count++;
        }
        if (this.hasBeenMarked(x + 1, y + 1) && this.hasBeenMarked( x + 2, y) && this.isMarkable(x + 1, y - 1)) {
          count++;
        }
      }
    }
    return count*2;
  }

  public int howManyTwosMade(int x, int y) {
    int count = 0;
    if (x%2 == 1 && y%2 == 0) { //this is a sideways dash -
      //check square above and below
      //square above
      if (y > 1) { //wont have a square above it being careful of array access
        if (this.hasBeenMarked(x - 1, y - 1) && this.isMarkable(x, y -2) && this.isMarkable(x + 1, y -1)) {
          count++;
        }
        if (this.hasBeenMarked(x, y - 2) && this.isMarkable(x + 1, y -1) && this.isMarkable(x - 1, y -1)) {
          count++;
        }
        if (this.isMarkable(x - 1, y -1) && this.hasBeenMarked( x +1, y - 1) && this.isMarkable(x, y -2)) {
          count++;
        }
      }
      //square below
      if (y < height - 1) { //dpesnt have a square below careful of array access
        if (this.hasBeenMarked(x -1 , y +1) && this.isMarkable(x + 1, y +1) && this.isMarkable(x, y +2)) {
          count++;
        }
        if (this.isMarkable(x -1, y +1) && this.hasBeenMarked(x, y + 2) && this.isMarkable(x + 1, y + 1)) {
          count++;
        }
        if (this.isMarkable(x, y + 2) && this.hasBeenMarked(x + 1, y +1) && this.isMarkable(x -1, y +1)) {
          count++;
        }
      }
    } else if (x%2 == 0 && y %2 == 1) { //this is a dash like |
      //square to left and right
      //left of dahs
      if (x > 1) { //makes sure its not side array access
        if (this.hasBeenMarked(x -1, y -1) && this.isMarkable(x -1, y + 1) && this.isMarkable(x -2, y)) {
          count++;
        }
        if (this.isMarkable(x -1, y -1) && this.hasBeenMarked(x -2, y) && this.isMarkable(x -1, y + 1)) {
          count++;
        }
        if (this.hasBeenMarked(x -1, y+1) && this.isMarkable(x -2 , y) && this.isMarkable(x -1, y - 1)) {
          count++;
        }
      }

      //right of it
      if (x < width - 1) {
        if (this.hasBeenMarked(x + 1, y -1) && this.isMarkable(x + 1, y +1) && this.isMarkable(x + 2, y)) {
          count++;
        }
        if (this.isMarkable( x + 1, y - 1) && this.hasBeenMarked( x + 2, y) && this.isMarkable(x + 1, y +1)) {
          count++;
        }
        if (this.hasBeenMarked(x + 1, y + 1) && this.isMarkable( x + 2, y) && this.isMarkable(x + 1, y - 1)) {
          count++;
        }
      }
    }
    return count*0.5;
  }

  public int howManySquaresMade(int x, int y ) {
    int count = 0;
    if (x%2 == 1 && y%2 == 0) { //this is a sideways dash -
      //check square above and below
      //square above
      if (y > 1) { //wont have a square above it being careful of array access
        if (this.hasBeenMarked(x - 1, y - 1) && this.hasBeenMarked(x, y -2) && this.hasBeenMarked(x + 1, y -1)) {
          count++;
        }
      }
      //square below
      if (y < height - 1) { //dpesnt have a square below careful of array access
        if (this.hasBeenMarked(x -1 , y +1) && this.hasBeenMarked(x + 1, y +1) && this.hasBeenMarked(x, y +2)) {
          count++;
        }
      }
    } else if (x%2 == 0 && y %2 == 1) { //this is a dash like |
      //square to left and right
      //left of dahs
      if (x > 1) { //makes sure its not side array access
        if (this.hasBeenMarked(x - 1, y -1) && this.hasBeenMarked(x -1, y + 1) && this.hasBeenMarked(x -2, y)) {
          count++;
        }
      }

      //right of it
      if (x < width - 1) {
        if (this.hasBeenMarked(x + 1, y -1) && this.hasBeenMarked(x + 1, y +1) && this.hasBeenMarked(x + 2, y)) {
          count++;
        }
      }
    }
    return count*2;
  }

  public boolean needsToBeFilled(int x, int y) {
    //need to write an assert comment here
    return plane[y][x - 1] != ' ' && plane[y][x + 1] != ' ' && plane[y - 1][x] != ' ' && plane[y + 1][x] != ' ' && isBlank(x, y);

  }

  public int howManyMiddleEmpty() {
    int count = 0;
    for (int y = 1; y < height - 1; y = y + 2) { //may as well start from 1
      for (int x = 1; x < width - 1; x = x + 2) {
        if (plane[y][x] == ' '){
          count++;
        }
      }
    }
    return count;
  }

  public int fillIn(char c) {
    int count = 0;
    for (int y = 1; y < height - 1; y = y + 2) { //may as well start from 1
      for (int x = 1; x < width - 1; x = x + 2) {
        if (needsToBeFilled(x, y)) {
          makeMark(c, x, y);
          count++;
        }
      }
    }
    return count;
  }

  public boolean isFinished() {
    for (int y = 1; y < height - 1; y = y + 2) { //may as well start from 1
      for (int x = 1; x < width - 1; x = x + 2) {
        if (plane[y][x] == ' '){
          return false;
        }
      }
    }
    return true;
  }

  public char charWon() {
    int BC = 0;
    int RC = 0;
    for (int y = 1; y < height - 1; y = y + 2) { //may as well start from 1
      for (int x = 1; x < width - 1; x = x + 2) {
        if (plane[y][x] == 'B'){
          BC++;
        } else {
          RC++;
        }
      }
    }
    if (BC > RC) {
      return 'B';
    } else if (RC > BC) {
      return 'R';
    } else {
      return 'T';
    }
  }


}
