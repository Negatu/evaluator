package evaluator.expressions.incomplete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.Before;

import evaluator.operations.UnaryOperation;
import evaluator.operations.UnaryMinusOperation;

public class UnaryRincExpressionTest {
    private UnaryRincExpression unaryRincExpression;
    private UnaryOperation operation;
    private IncompleteExpression incompleteOperand;

    @Before
    public void setUp() {
        operation = new UnaryMinusOperation();
        incompleteOperand = new EmptyExpression();
        unaryRincExpression = new UnaryRincExpression(operation, incompleteOperand);
    }

    @Test
    public void getOperation_returnsOperation() {
        assertThat(unaryRincExpression.getOperation()).isEqualTo(operation);
    }

    @Test
    public void getOperand_returnsIncompleteOperand() {
        assertThat(unaryRincExpression.getOperand()).isEqualTo(incompleteOperand);
    }

    @Test
    public void getChildren_returnsOperationAndIncompleteOperand() {
        assertThat(unaryRincExpression.getChildren()).containsExactly(operation, incompleteOperand);
    }

}
