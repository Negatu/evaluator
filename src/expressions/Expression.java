package evaluator.expressions;

import evaluator.SyntaxNode;
import evaluator.values.NumberValue;
import evaluator.tokens.Token;

/*
 * Represents an expression node in the parse tree. 
 */
public abstract class Expression implements SyntaxNode {
    public ExpressionExtender<Expression> extender;

    public Expression(ExpressionExtender<Expression> extender) {
        this.extender = extender;
    }

    /*
     * Returns a new expression node that is the result of extending this expression
     * node with the given token.
     */
    public Expression extend(Token token) {
        return extender.extend(this, token);
    }

    /*
     * Returns a value expression that is the result of evaluating this expression
     * node.
     */
    public abstract NumberValue eval();
}
