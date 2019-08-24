public class TreeLeaf implements Comparable<TreeLeaf> {
  private Move move;
  private int goodIdea; //lower the better

  public TreeLeaf(Move move, int goodIdea) {
    this.move = move;
    this.goodIdea = goodIdea;
  }

  public Move getMove() {
    return move;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof TreeLeaf)) {
      return false;
    } else {
      return move.equals(((TreeLeaf) o).getMove());
    }
  }

  @Override
  public int hashCode() {
    return goodIdea;
  }

  @Override
  public int compareTo(TreeLeaf leaf) {
    if (this.goodIdea < leaf.goodIdea) { //it is bigger in effect if its smaller
      return 1;
    } else if (this.goodIdea > leaf.goodIdea) {
      return -1;
    } else {
      return 0;
    }
  }
}