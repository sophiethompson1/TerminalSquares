public class AIPlayer extends Player {

  public AIPlayer(Colour colour) {
    super("AI1", colour);
  }

  @Override
  public Move takeTurn(Paper paper) {
    DecisionTree dt2 = new DecisionTree(paper);
    dt2.makeDecisionTree();
    return dt2.getBestMove();
  }
}