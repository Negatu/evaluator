package evaluator.expressions.complete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryTimesOperation;
import evaluator.values.NumberValue;

public class BinaryExpressionTest {

    private BinaryExpression binaryExpression;
    private BinaryOperation operation;
    private CompleteExpression left;
    private CompleteExpression right;

    @Before
    public void setUp() {
        operation = new BinaryTimesOperation();
        left = new NumberExpression(5);
        right = new NumberExpression(3);
        binaryExpression = new BinaryExpression(operation, left, right);
    }

    @Test
    public void eval_appliesOperationToOperands() {
        assertThat(binaryExpression.eval()).isEqualTo(new NumberValue(15));
    }

    @Test
    public void getChildren_returnsOperationAndOperands() {
        assertThat(binaryExpression.getChildren()).hasSize(3);
        assertThat(binaryExpression.getChildren()).contains(operation);
        assertThat(binaryExpression.getChildren()).contains(left);
        assertThat(binaryExpression.getChildren()).contains(right);
    }

    @Test
    public void getOperation_returnsOperation() {
        assertThat(binaryExpression.getOperation()).isEqualTo(operation);
    }

    @Test
    public void getLeft_returnsLeftOperand() {
        assertThat(binaryExpression.getLeft()).isEqualTo(left);
    }

    @Test
    public void getRight_returnsRightOperand() {
        assertThat(binaryExpression.getRight()).isEqualTo(right);
    }

}
