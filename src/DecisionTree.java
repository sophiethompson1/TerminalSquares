import java.util.*;

public class DecisionTree {
  private PriorityQueue<TreeLeaf> queue;
  private Game game;

  public DecisionTree(Game game) {
    this.game = game;
    this.queue = new PriorityQueue<TreeLeaf>();
  }

  public Move getBestMove() {
    return this.queue.poll().getMove();
  }

  public void makeDecisionTree() {
    Paper paper = this.game.getPaper();

    //need to go through grid and all empty
    //slots need to work out best place
    for (int y = 0; y < paper.getHeight(); y++) {
      for (int x = 0; x < paper.getWidth(); x++) {
        if(paper.isMarkable(x, y)) {
      }
    }
  }
}

//idea is priority is 0 if it will make a square
//1 if it doesnt let the other person make a square
//2 onwards if it lets the other person make a square higher depending on how many squares