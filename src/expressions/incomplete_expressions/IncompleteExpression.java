package evaluator.expressions.incomplete_expressions;

import evaluator.values.NumberValue;
import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;

/*
 * Represents a partial expression that can not be evaluated.
 */
public abstract class IncompleteExpression extends Expression {

    public IncompleteExpression(ExpressionExtender extender) {
        super(extender);
    }

    @Override
    public NumberValue eval() {
        throw new RuntimeException("Can not eval  an incomplete expression");
    }
}