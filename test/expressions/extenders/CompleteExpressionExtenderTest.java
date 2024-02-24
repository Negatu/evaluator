package evaluator.expressions.extenders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.BinaryExpression;
import evaluator.expressions.complete_expressions.NumberExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryPlusOperation;
import evaluator.operations.BinaryMinusOperation;
import evaluator.operations.BinaryTimesOperation;
import evaluator.tokens.OpToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.TimesToken;

public class CompleteExpressionExtenderTest {

    private CompleteExpressionExtender completeExpressionExtender;
    private CompleteExpression completeExpression;

    @Before
    public void setUp() {
        completeExpressionExtender = new CompleteExpressionExtender();
        completeExpression = new BinaryExpression(new BinaryPlusOperation(), new NumberExpression(7),
                new NumberExpression(13));
    }

    private static Stream<Arguments> opTokensAndOperations() {
        return Stream.of(
                arguments(new PlusToken(), new BinaryPlusOperation()),
                arguments(new MinusToken(), new BinaryMinusOperation()),
                arguments(new TimesToken(), new BinaryTimesOperation()));
    }

    @ParameterizedTest
    @MethodSource("opTokensAndOperations")
    public void extend_withOpToken_returnsBinaryRincExpression(OpToken inputToken, BinaryOperation expectedOperation) {
        BinaryRincExpression brincExpression = completeExpressionExtender.extend(completeExpression, inputToken);

        assertThat(brincExpression.getLeft()).isEqualTo(completeExpression);
        assertThat(brincExpression.getRight()).isEqualTo(new EmptyExpression());
        assertThat(brincExpression.getOperation()).isEqualTo(expectedOperation);
    }

    @Test
    public void extend_withLeftBracketToken_returnsBinaryRincExpressionWithTimesOperation() {
        OpenParenExpression expectedEmptyParenExpression = new OpenParenExpression(new EmptyExpression());
        BinaryRincExpression brincExpression = completeExpressionExtender.extend(completeExpression,
                new LeftBracketToken());

        assertThat(brincExpression.getLeft()).isEqualTo(completeExpression);
        assertThat(brincExpression.getRight()).isEqualTo(expectedEmptyParenExpression);
        assertThat(brincExpression.getOperation()).isInstanceOf(BinaryTimesOperation.class);
    }

}
