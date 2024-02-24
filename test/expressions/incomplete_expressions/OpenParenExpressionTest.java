package evaluator.expressions.incomplete_expressions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import evaluator.expressions.Expression;

public class OpenParenExpressionTest {
    private Expression innerExpression;

    @Before
    public void setUp() {
        innerExpression = mock(Expression.class);
    }

    @Test
    public void getInnerExpression_returnsInnerExpression() {
        OpenParenExpression expression = new OpenParenExpression(innerExpression);
        assertThat(expression.getInnerExpression()).isEqualTo(innerExpression);
    }

    @Test
    public void getChildren_returnsInnerExpression() {
        OpenParenExpression expression = new OpenParenExpression(innerExpression);
        assertThat(expression.getChildren()).containsExactly(innerExpression);
    }

}
