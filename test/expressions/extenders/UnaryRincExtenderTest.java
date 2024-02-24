package evaluator.expressions.extenders;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import evaluator.expressions.Expression;
import evaluator.expressions.complete_expressions.UnaryExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.expressions.incomplete_expressions.UnaryRincExpression;
import evaluator.operations.UnaryMinusOperation;
import evaluator.tokens.Token;
import evaluator.tokens.NumberToken;
import evaluator.tokens.PlusToken;

public class UnaryRincExtenderTest {
    private UnaryRincExtender unaryRincExtender;
    private UnaryRincExpression expression;

    @Before
    public void setUp() {
        unaryRincExtender = new UnaryRincExtender();
        expression = new UnaryRincExpression(new UnaryMinusOperation(), new EmptyExpression());
    }

    @Test
    public void extend_whenOperandIsComplete_returnUnaryExpression() {
        Token completingToken = new NumberToken(5);

        Expression result = unaryRincExtender.extend(expression, completingToken);

        assertThat(result).isInstanceOf(UnaryExpression.class);
    }

    @Test
    public void extend_whenOperandIsIncomplete_returnUnaryRincExpression() {
        Token nonCompletingToken = new PlusToken();

        Expression result = unaryRincExtender.extend(expression, nonCompletingToken);

        assertThat(result).isInstanceOf(UnaryRincExpression.class);
    }

}
