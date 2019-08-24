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
    System.out.println(baseGoodIdea);
    //need to go through grid and all empty
    //slots need to work out best place
    for (int y = 0; y < paper.getHeight(); y++) {
      for (int x = 0; x < paper.getWidth(); x++) {
        System.out.println("X: " + x + "Y: " + y);
        if(paper.isMarkable(x, y)) {
          workingBase -= paper.madeAThree(x, y);
          workingBase += paper.howManySquaresMade(x, y);
          System.out.println("Total for " + x + " " + y + " " + workingBase);
          TreeLeaf leaf = new TreeLeaf(new Move(x, y), workingBase);
          this.queue.add(leaf);
        }
        workingBase = baseGoodIdea; //resets number
      }
    }
  }

  public static void main(String[] args) {
    Paper paper = new Paper(3, 3);
    paper.makeMark('B', 1, 0);
    paper.makeMark('B', 3, 0);
    paper.makeMark('B', 0, 1);
    paper.makeMark('B', 0, 3);
    paper.makeMark('B', 1, 2);
    paper.makeMark('B', 2, 3);
    paper.makeMark('B', 4, 1);
    paper.printPaper();
    DecisionTree dt2 = new DecisionTree(paper);
    dt2.makeDecisionTree();
    System.out.println(dt2.getBestMove().toString());
  }
}

//needs to go for the best option so more that can be filled the better the idea
//idea is priority is 0 if it will make a square
//1 if it doesnt let the other person make a square
//2 onwards if it lets the other person make a square higher depending on how many squares

//depends on rules are the rules that the person gets another turn if filled a square