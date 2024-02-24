package evaluator.expressions.extenders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import evaluator.expressions.Expression;
import evaluator.expressions.complete_expressions.NumberExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.expressions.incomplete_expressions.UnaryRincExpression;
import evaluator.operations.UnaryOperation;
import evaluator.operations.UnaryMinusOperation;
import evaluator.operations.UnaryPlusOperation;
import evaluator.tokens.Token;
import evaluator.tokens.OpToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.NumberToken;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.RightBracketToken;

public class EmptyExpressionExtenderTest {
    private EmptyExpression expression;
    private EmptyExpressionExtender extender;

    @Before
    public void setUp() {
        expression = new EmptyExpression();
        extender = new EmptyExpressionExtender();
    }

    private static Stream<Arguments> opTokensAndUnaryOperations() {
        return Stream.of(
                arguments(new PlusToken(), new UnaryPlusOperation()),
                arguments(new MinusToken(), new UnaryMinusOperation()));
    }

    @Test
    public void extend_withNumberToken_returnsNumberExpression() {
        Token token = new NumberToken(5);

        Expression result = extender.extend(expression, token);

        assertThat(result).isInstanceOf(NumberExpression.class);
    }

    @ParameterizedTest
    @MethodSource("opTokensAndUnaryOperations")
    public void extend_withOpToken_returnsUnaryRincExpression(OpToken opToken, UnaryOperation expectedUnaryOperation) {
        Expression result = extender.extend(expression, opToken);

        assertThat(result).isInstanceOf(UnaryRincExpression.class);
        UnaryRincExpression unaryRincExpression = (UnaryRincExpression) result;
        assertThat(unaryRincExpression.getOperation()).isEqualTo(expectedUnaryOperation);
    }

    @Test
    public void extend_withLeftBracketToken_returnsOpenParenExpression() {
        Expression result = extender.extend(expression, new LeftBracketToken());

        assertThat(result).isInstanceOf(OpenParenExpression.class);
    }

    @Test
    public void extend_withInvalidToken_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            extender.extend(expression, new RightBracketToken());
        });
    }
}
