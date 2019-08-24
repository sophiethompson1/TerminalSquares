import java.util.*;

public class DecisionTree {
  private PriorityQueue<TreeLeaf> queue;
  //private Game game;
  private Paper paper;

  public DecisionTree(Paper paper) {
    this.paper = paper;
    this.queue = new PriorityQueue<TreeLeaf>();
  }

  public Move getBestMove() {
    return this.queue.poll().getMove();
  }

  public void makeDecisionTree() {
    //Paper paper = this.game.getPaper();

    int baseGoodIdea = paper.howManyMiddleEmpty();
    int workingBase = baseGoodIdea;
    //need to go through grid and all empty
    //slots need to work out best place
    for (int y = 0; y < paper.getHeight(); y++) {
      for (int x = 0; x < paper.getWidth(); x++) {
        if(paper.isMarkable(x, y)) {
          workingBase -= paper.madeAThree(x, y);
          workingBase += paper.howManySquaresMade(x, y);
          TreeLeaf leaf = new TreeLeaf(new Move(x, y), workingBase);
          this.queue.add(leaf);
        }
        workingBase = baseGoodIdea; //resets number
      }
    }
  }

  public static void main(String[] args) {

  }
}

//needs to go for the best option so more that can be filled the better the idea
//idea is priority is 0 if it will make a square
//1 if it doesnt let the other person make a square
//2 onwards if it lets the other person make a square higher depending on how many squares

//depends on rules are the rules that the person gets another turn if filled a square