package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.expressions.complete_expressions.BinaryExpression;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryTimesOperation;
import evaluator.operations.Precedence;
import evaluator.tokens.Token;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.OpToken;

/*
 * Extends complete binary expressions into binary right incomplete expressions.
 * e.g. 5 + 3 -> extended with '*' -> 5 +  3 * _  (* takes precedence over + and _ is an empty expression)
  */
public class BinaryExpressionExtender extends ExpressionExtender<BinaryExpression> {

    @Override
    public Expression extend(BinaryExpression expression, Token token) {
        if (token instanceof OpToken) {
            return extendBinaryToBrinc(expression, BinaryOperation.from((OpToken) token));
        } else if (token instanceof LeftBracketToken) {
            BinaryRincExpression extendedWithTimes = extendBinaryToBrinc(expression,
                    new BinaryTimesOperation());
            return extendedWithTimes.extend(token);
        } else {
            throw new IllegalArgumentException(String.format(
                    "Unable to extend binary expression with token '%s'.", token));
        }
    }

    private BinaryRincExpression extendBinaryToBrinc(BinaryExpression expression, BinaryOperation operation) {
        if (Precedence.of(operation) > Precedence.of(expression.getOperation())) {
            // right side of expression needs to run the higher precedence operation first
            BinaryRincExpression newRight = extendCompleteToBrinc(expression.getRight(), operation);
            return new BinaryRincExpression(expression.getOperation(), expression.getLeft(), newRight);
        } else {
            return new BinaryRincExpression(operation, expression, new EmptyExpression());
        }
    }

    private BinaryRincExpression extendCompleteToBrinc(CompleteExpression expression,
            BinaryOperation operation) {
        if (expression instanceof BinaryExpression) {
            // recursively extend the right side of the binary expression
            return extendBinaryToBrinc((BinaryExpression) expression, operation);
        }
        return new BinaryRincExpression(operation, expression, new EmptyExpression());
    }
}