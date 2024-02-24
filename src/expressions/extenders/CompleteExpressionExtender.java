package evaluator.expressions.extenders;

import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.expressions.incomplete_expressions.OpenParenExpression;
import evaluator.expressions.incomplete_expressions.BinaryRincExpression;
import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryTimesOperation;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.OpToken;
import evaluator.tokens.Token;

/*
 * Takes a CompleteExpression and a Token and extends it to a right incomplete expression with the Token.
 * e.g. 1 + 2 --> extend with + --> 1 + 2 +
 */
public class CompleteExpressionExtender extends ExpressionExtender<CompleteExpression> {

    @Override
    public BinaryRincExpression extend(CompleteExpression expression, Token token) {

        if (token instanceof OpToken) {
            return new BinaryRincExpression(BinaryOperation.from((OpToken) token), expression,
                    new EmptyExpression());
        } else if (token instanceof LeftBracketToken) {
            // Assume left bracket token without explicit operation is a multiplication
            OpenParenExpression emptyParenExpression = new OpenParenExpression(new EmptyExpression());
            return new BinaryRincExpression(new BinaryTimesOperation(), expression, emptyParenExpression);
        } else {
            throw new IllegalArgumentException(String.format("Unable to extend '%s' with '%s'", expression, token));
        }
    }
}