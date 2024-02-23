package evaluator.expressions.incomplete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import evaluator.expressions.incomplete_expressions.EmptyExpression;

public class OpenPRincExpressionTest {
    private OpenPRincExpression openPRincExpression;
    private IncompleteExpression innerExpression;

    @Before
    public void setUp() {
        innerExpression = new EmptyExpression();
        openPRincExpression = new OpenPRincExpression(innerExpression);
    }

    @Test
    public void getChildren_returnsInnerExpression() {
        assertThat(openPRincExpression.getChildren()).containsExactly(innerExpression);
    }

}
