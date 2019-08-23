public class TreeLeaf {
  private Move move;
  private int goodIdea; //lower the better

  public TreeLeaf(Move move, int goodIdea) {
    this.move = move;
    this.goodIdea = goodIdea;
  }

  public Move getMove() {
    return move;
  }
}