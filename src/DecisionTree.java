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

  }
}