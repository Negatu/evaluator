package evaluator.expressions.incomplete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.Before;

import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.NumberExpression;
import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryTimesOperation;

public class BinaryRincExpressionTest {
    private BinaryRincExpression binaryRincExpression;
    private BinaryOperation operation;
    private CompleteExpression left;
    private IncompleteExpression right;

    @Before
    public void setUp() {
        operation = new BinaryTimesOperation();
        left = new NumberExpression(5);
        right = new EmptyExpression();
        binaryRincExpression = new BinaryRincExpression(operation, left, right);
    }

    @Test
    public void getOperation_returnsOperation() {
        assertThat(binaryRincExpression.getOperation()).isEqualTo(operation);
    }

    @Test
    public void getLeft_returnsLeftOperand() {
        assertThat(binaryRincExpression.getLeft()).isEqualTo(left);
    }

    @Test
    public void getRight_returnsRightOperand() {
        assertThat(binaryRincExpression.getRight()).isEqualTo(right);
    }

    @Test
    public void getChildren_returnsOperationAndOperands() {
        assertThat(binaryRincExpression.getChildren()).containsExactly(operation, left, right);
    }
}
