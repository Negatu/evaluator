package evaluator.expressions.extenders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import evaluator.expressions.Expression;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.BinaryExpression;
import evaluator.expressions.extenders.BinaryExpressionExtender;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryPlusOperation;
import evaluator.operations.BinaryTimesOperation;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.OpToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.RightBracketToken;
import evaluator.tokens.TimesToken;

public class BinaryExpressionExtenderTest {
    private BinaryExpressionExtender extender;
    private BinaryExpression binaryExpression;
    private CompleteExpression leftExpression;
    private CompleteExpression rightExpression;
    private EmptyExpression emptyExpression;
    private BinaryOperation plusOperation;
    private BinaryOperation timesOperation;

    @Before
    public void setUp() {
        extender = new BinaryExpressionExtender();
        leftExpression = mock(CompleteExpression.class);
        rightExpression = mock(CompleteExpression.class);
        emptyExpression = new EmptyExpression();
        plusOperation = new BinaryPlusOperation();
        timesOperation = new BinaryTimesOperation();
    }

    // Binary(5 + 3) -> extended with '+' -> Binary(Binary(5 + 3) + Empty)
    @Test
    public void extend_withNonHigherPrecedenceOpToken_returnsBinaryRincExpression() {
        binaryExpression = new BinaryExpression(plusOperation, leftExpression, rightExpression);

        Expression expression = extender.extend(binaryExpression, new PlusToken());

        assertThat(expression).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression binaryRincExpression = (BinaryRincExpression) expression;
        assertThat(binaryRincExpression.getOperation()).isInstanceOf(BinaryPlusOperation.class);
        assertThat(binaryRincExpression.getLeft()).isEqualTo(binaryExpression);
        assertThat(binaryRincExpression.getRight()).isEqualTo(emptyExpression);
    }

    // Binary(5 + 3) -> extended with '*' -> 5 + Binary(3 * Empty)
    @Test
    public void extend_withHigherPrecedenceOpToken_returnsReArrangedBinaryRincExpression() {
        binaryExpression = new BinaryExpression(plusOperation, leftExpression, rightExpression);

        Expression expression = extender.extend(binaryExpression, new TimesToken());

        assertThat(expression).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression binaryRincExpression = (BinaryRincExpression) expression;
        // lower precedence op is higher in the parse tree
        assertThat(binaryRincExpression.getOperation()).isInstanceOf(BinaryPlusOperation.class);
        assertThat(binaryRincExpression.getLeft()).isEqualTo(binaryExpression.getLeft());
        assertThat(binaryRincExpression.getRight()).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression rightRinc = (BinaryRincExpression) binaryRincExpression.getRight();
        // higher precedence op is lower in the parse tree
        assertThat(rightRinc.getOperation()).isInstanceOf(BinaryTimesOperation.class);
        assertThat(rightRinc.getLeft()).isEqualTo(binaryExpression.getRight());
        assertThat(rightRinc.getRight()).isEqualTo(emptyExpression);
    }

    // Binary(C1 + Binary(C2 + C3)) -> extended with '*' -> Binary(C1 + Binary(C2 +
    // Binary(C3 * Empty)))
    @Test
    public void extend_withHigherPrecedenceToken_recursivelyReArrangesBinaryRincExpression() {
        CompleteExpression c1 = mock(CompleteExpression.class);
        CompleteExpression c2 = mock(CompleteExpression.class);
        CompleteExpression c3 = mock(CompleteExpression.class);
        BinaryExpression level2Expression = new BinaryExpression(plusOperation, c2, c3);
        BinaryExpression level1Expression = new BinaryExpression(plusOperation, c1, level2Expression);

        Expression expression = extender.extend(level1Expression, new TimesToken());

        assertThat(expression).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression binaryRincExpression = (BinaryRincExpression) expression;
        assertThat(binaryRincExpression.getOperation()).isInstanceOf(BinaryPlusOperation.class);
        assertThat(binaryRincExpression.getLeft()).isEqualTo(c1);
        assertThat(binaryRincExpression.getRight()).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression rightRinc = (BinaryRincExpression) binaryRincExpression.getRight();
        assertThat(rightRinc.getOperation()).isInstanceOf(BinaryPlusOperation.class);
        assertThat(rightRinc.getLeft()).isEqualTo(c2);
        assertThat(rightRinc.getRight()).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression rightRightRinc = (BinaryRincExpression) rightRinc.getRight();
        assertThat(rightRightRinc.getOperation()).isInstanceOf(BinaryTimesOperation.class);
        assertThat(rightRightRinc.getLeft()).isEqualTo(c3);
        assertThat(rightRightRinc.getRight()).isEqualTo(emptyExpression);
    }

    // Binary(5 + 3) -> extended with '(' -> Binary(5 + Binary(3 * OpenParenthesis))
    @Test
    public void extend_withLeftBracketToken_returnsTimesWithOpenParenExpression() {
        binaryExpression = new BinaryExpression(plusOperation, leftExpression, rightExpression);

        Expression expression = extender.extend(binaryExpression, new LeftBracketToken());

        assertThat(expression).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression binaryRincExpression = (BinaryRincExpression) expression;
        assertThat(binaryRincExpression.getOperation()).isInstanceOf(BinaryPlusOperation.class);
        assertThat(binaryRincExpression.getLeft()).isEqualTo(binaryExpression.getLeft());
        assertThat(binaryRincExpression.getRight()).isInstanceOf(BinaryRincExpression.class);
        BinaryRincExpression rightRinc = (BinaryRincExpression) binaryRincExpression.getRight();
        assertThat(rightRinc.getOperation()).isInstanceOf(BinaryTimesOperation.class);
        assertThat(rightRinc.getLeft()).isEqualTo(binaryExpression.getRight());
        assertThat(rightRinc.getRight()).isInstanceOf(OpenParenExpression.class);
    }

    @Test
    public void extend_withInvalidToken_throwsIllegalArgumentException() {
        binaryExpression = new BinaryExpression(plusOperation, leftExpression, rightExpression);

        assertThrows(IllegalArgumentException.class, () -> extender.extend(binaryExpression, new RightBracketToken()));

    }
}
