package evaluator.expressions.extenders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Before;
import org.junit.Test;

import evaluator.expressions.Expression;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.NumberExpression;
import evaluator.expressions.complete_expressions.BinaryExpression;
import evaluator.expressions.complete_expressions.ClosedPExpression;
import evaluator.expressions.incomplete_expressions.IncompleteExpression;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.operations.BinaryPlusOperation;
import evaluator.tokens.NumberToken;
import evaluator.tokens.RightBracketToken;

public class OpenParenExtenderTest {
    private IncompleteExpression incompleteExpression;
    private CompleteExpression completeExpression;
    private OpenParenExtender extender;

    @Before
    public void setUp() {
        incompleteExpression = mock(IncompleteExpression.class);
        completeExpression = mock(CompleteExpression.class);
    }

    @Test
    public void extend_whenCompleteInner_withRightBracket_returnsClosedPExpression() {
        OpenParenExtender extender = new OpenParenExtender();
        OpenParenExpression expression = new OpenParenExpression(completeExpression);

        Expression result = extender.extend(expression, new RightBracketToken());

        assertThat(result).isInstanceOf(ClosedPExpression.class);
    }

    @Test
    public void extend_whenIncompleteInner_extendsInnerExpression() {
        OpenParenExtender extender = new OpenParenExtender();
        OpenParenExpression expression = new OpenParenExpression(incompleteExpression);
        when(incompleteExpression.extend(any())).thenReturn(completeExpression);

        Expression result = extender.extend(expression, new NumberToken(6));

        verify(incompleteExpression).extend(any());
        assertThat(result).isInstanceOf(OpenParenExpression.class);
        assertThat(result.getChildren()).containsExactly(completeExpression);
    }

}
