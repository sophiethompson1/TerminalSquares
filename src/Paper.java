
public class Paper {
  private final int width;
  private final int height;
  private char[][] plane;

  public Paper(int width, int height) {
    assert (width > 2) && (height > 2) : "not large enough";
    this.width = width;
    this.height = height;
    initialisePaper();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  private void initialisePaper() {
    plane = new char[height*2 + 1][width*2 + 1];
    for(int y = 0; y < height*2 + 1; y++) {
      for(int x = 0; x < width*2 + 1; x++) {
        if(y % 2 == 0 && x % 2 == 0) {
          plane[y][x] = 'o';
        } else {
          plane[y][x] = ' ';
        }
      }
    }
  }

  public String printPaper() {
    String output = "";
    for(int y = 0; y < height*2 + 1; y++) {
      for(int x = 0; x < width*2 + 1; x++) {
        output += plane[y][x];
      }
      output += '\n';
    }
    return output;
  }

  public boolean makeMark(char c, int x, int y) {
    plane[y*2 + 1][x*2 + 1] = c;
  }

  public static void main(String[] args) {
    Paper paper = new Paper(3, 3);
    System.out.println(paper.printPaper());

  }

}
