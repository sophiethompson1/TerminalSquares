public class TestingPaper extends Paper {

  public TestingPaper(int width, int height) {
    super(width, height);
  }

  public void removeMark(int x, int y) {
    this.plane[y][x] = ' ';
  }
}