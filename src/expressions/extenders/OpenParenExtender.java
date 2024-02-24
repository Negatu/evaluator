package evaluator.expressions.extenders;

import evaluator.tokens.Token;
import evaluator.expressions.Expression;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.complete_expressions.ClosedPExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.expressions.ExpressionExtender;
import evaluator.tokens.RightBracketToken;

/*
 * Extends open parenthesis expressions into a closed parenthesis expression or another open parenthesis expression.
 */
public class OpenParenExtender extends ExpressionExtender<OpenParenExpression> {

    @Override
    public Expression extend(OpenParenExpression expression, Token token) {

        if (token instanceof RightBracketToken && expression.getInnerExpression() instanceof CompleteExpression) {
            return new ClosedPExpression((CompleteExpression) expression.getInnerExpression());
        }

        Expression extendedInner = expression.getInnerExpression().extend(token);
        return new OpenParenExpression(extendedInner);
    }
}