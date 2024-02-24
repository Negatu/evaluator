package evaluator.expressions.extenders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import evaluator.expressions.Expression;
import evaluator.expressions.complete_expressions.BinaryExpression;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.expressions.incomplete_expressions.IncompleteExpression;
import evaluator.operations.BinaryPlusOperation;
import evaluator.tokens.Token;

public class BinaryRincExtenderTest {
    private BinaryRincExtender extender;
    private BinaryRincExpression expression;
    private CompleteExpression leftExpression;
    private IncompleteExpression rightExpression;

    @Before
    public void setUp() {
        leftExpression = mock(CompleteExpression.class);
        rightExpression = mock(IncompleteExpression.class);
        extender = new BinaryRincExtender();
        expression = new BinaryRincExpression(new BinaryPlusOperation(), leftExpression, rightExpression);
    }

    @Test
    public void extend_whenRightIsIncomplete_returnBinaryRincExpression() {
        when(rightExpression.extend(any())).thenReturn(mock(IncompleteExpression.class));

        Expression result = extender.extend(expression, mock(Token.class));

        assertThat(result).isInstanceOf(BinaryRincExpression.class);
    }

    @Test
    public void extend_whenRightIsComplete_returnBinaryExpression() {
        when(rightExpression.extend(any())).thenReturn(mock(CompleteExpression.class));

        Expression result = extender.extend(expression, mock(Token.class));

        assertThat(result).isInstanceOf(BinaryExpression.class);
    }

}
