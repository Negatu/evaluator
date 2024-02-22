package evaluator.expressions.complete_expressions;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import evaluator.SyntaxNode;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.operations.UnaryMinusOperation;
import evaluator.operations.UnaryOperation;
import evaluator.values.NumberValue;

public class UnaryExpressionTest {

    private UnaryExpression unaryExpression;
    private UnaryOperation operation;
    private CompleteExpression operand;

    @Before
    public void setUp() {
        operation = new UnaryMinusOperation();
        operand = new NumberExpression(5);
        unaryExpression = new UnaryExpression(operation, operand);
    }

    @Test
    public void testEval() {
        NumberValue expectedValue = new NumberValue(-5);
        assertThat(unaryExpression.eval()).isEqualTo(expectedValue);
    }

    @Test
    public void testGetChildren() {
        ArrayList<SyntaxNode> children = unaryExpression.getChildren();
        assertThat(children).hasSize(2);
        assertThat(children).contains(operation);
        assertThat(children).contains(operand);
    }

}