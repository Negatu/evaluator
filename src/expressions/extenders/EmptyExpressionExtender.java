package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.tokens.Token;

public class EmptyExpressionExtender extends ExpressionExtender<EmptyExpression> {
    @Override
    public Expression extend(EmptyExpression expression, Token token) {
        return null;
    }
}