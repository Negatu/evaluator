package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.tokens.Token;

/*
 * Placeholder extender for expressions that do not have their extenders implemented yet.
 */
public class UnimplementedExpressionExtender extends ExpressionExtender<Expression> {
    @Override
    public Expression extend(Expression expression, Token token) {
        throw new UnsupportedOperationException(
                String.format("ExpressionExtender not yet implemented for the expression class '%s'",
                        expression.getClass()));
    }
}