package evaluator.expressions.complete_expressions;

import evaluator.values.NumberValue;
import evaluator.expressions.Expression;
import evaluator.expressions.ExpressionExtender;

/*
 * Represents an expression that can be evaluated into a NumberValue.
 */
public abstract class CompleteExpression extends Expression {

    public CompleteExpression(ExpressionExtender extender) {
        super(extender);
    }

    abstract public NumberValue eval();
}