package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.expressions.complete_expressions.NumberExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.expressions.incomplete_expressions.UnaryRincExpression;
import evaluator.tokens.Token;
import evaluator.tokens.OpToken;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.NumberToken;

public class EmptyExpressionExtender extends ExpressionExtender<EmptyExpression> {
    @Override
    public Expression extend(EmptyExpression expression, Token token) {
        if (token instanceof NumberToken) {
            return new NumberExpression(((NumberToken) token).getNumber());
        } else if (token instanceof OpToken) {
            return UnaryRincExpression.from((OpToken) token);
        } else if (token instanceof LeftBracketToken) {
            return OpenParenExpression.ofEmpty();
        } else {
            throw new IllegalArgumentException(String.format("Unable to extend EmptyExpression with token %s", token));
        }
    }
}