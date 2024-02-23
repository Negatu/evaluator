package evaluator.expressions.complete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import evaluator.values.NumberValue;
import evaluator.SyntaxNode;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.NumberExpression;

public class ClosedPExpressionTest {

    private ClosedPExpression closedPExpression;
    private CompleteExpression completeExpression;

    @Before
    public void setUp() {
        completeExpression = new NumberExpression(12);
        closedPExpression = new ClosedPExpression(completeExpression);
    }

    @Test
    public void eval_returnsInnerExpressionEval() {
        NumberValue expected = new NumberValue(12);
        NumberValue result = closedPExpression.eval();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void getChildren_returnsInnerExpression() {
        ArrayList<SyntaxNode> children = closedPExpression.getChildren();
        assertThat(children).containsExactly(completeExpression);
    }

}
