package evaluator.expressions;

import evaluator.tokens.Token;

/*
 * Holds the logic for extending an expression node with a token.
 */
public abstract class ExpressionExtender<E extends Expression> {

    public abstract Expression extend(E expression, Token token);
}
