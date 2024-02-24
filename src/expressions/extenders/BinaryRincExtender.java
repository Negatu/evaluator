package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.expressions.complete_expressions.BinaryExpression;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.expressions.incomplete_expressions.IncompleteExpression;
import evaluator.tokens.Token;

public class BinaryRincExtender extends ExpressionExtender<BinaryRincExpression> {

    @Override
    public Expression extend(BinaryRincExpression expression, Token token) {
        Expression newRight = expression.getRight().extend(token);
        return binaryOrBrinc(expression, newRight);
    }

    private Expression binaryOrBrinc(BinaryRincExpression expression, Expression newRight) {
        if (newRight instanceof CompleteExpression) {
            return new BinaryExpression(expression.getOperation(), expression.getLeft(),
                    (CompleteExpression) newRight);
        } else if (newRight instanceof IncompleteExpression) {
            return new BinaryRincExpression(expression.getOperation(), expression.getLeft(),
                    (IncompleteExpression) newRight);
        } else {
            throw new RuntimeException(String.format(
                    "Unexpected expression type. Expression: '%s' is neither complete nor incomplete.", newRight));
        }
    }
}