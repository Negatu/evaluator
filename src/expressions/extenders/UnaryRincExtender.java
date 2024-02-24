package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.UnaryExpression;
import evaluator.expressions.incomplete_expressions.IncompleteExpression;
import evaluator.expressions.incomplete_expressions.UnaryRincExpression;
import evaluator.tokens.Token;
import evaluator.operations.UnaryOperation;

/*
 * Extends unary right incomplete expressions into a complete unary expression or another unary right incomplete expression.
 */
public class UnaryRincExtender extends ExpressionExtender<UnaryRincExpression> {

    @Override
    public Expression extend(UnaryRincExpression expression, Token token) {
        Expression newOperand = expression.getOperand().extend(token);
        return unaryOrUrinc(expression.getOperation(), newOperand);
    }

    private Expression unaryOrUrinc(UnaryOperation operation, Expression operand) {
        if (operand instanceof CompleteExpression) {
            return new UnaryExpression(operation, (CompleteExpression) operand);
        } else if (operand instanceof IncompleteExpression) {
            return new UnaryRincExpression(operation, (IncompleteExpression) operand);
        } else {
            throw new RuntimeException(String.format(
                    "Unexpected expression type. Expression: '%s' is neither complete nor incomplete.", operand));
        }
    }
}