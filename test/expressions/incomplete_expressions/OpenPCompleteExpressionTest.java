package evaluator.expressions.incomplete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import evaluator.values.NumberValue;
import evaluator.SyntaxNode;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.NumberExpression;

public class OpenPCompleteExpressionTest {
    private OpenPCompleteExpression openPCompleteExpression;
    private CompleteExpression completeExpression;

    @Before
    public void setUp() {
        completeExpression = new NumberExpression(12);
        openPCompleteExpression = new OpenPCompleteExpression(completeExpression);
    }

    @Test
    public void getChildren_returnsInnerExpression() {
        ArrayList<SyntaxNode> children = openPCompleteExpression.getChildren();
        assertThat(children).containsExactly(completeExpression);
    }

}
