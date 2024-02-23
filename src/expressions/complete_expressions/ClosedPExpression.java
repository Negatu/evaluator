package evaluator.expressions.complete_expressions;

import java.util.ArrayList;
import evaluator.values.NumberValue;
import evaluator.SyntaxNode;
import evaluator.expressions.extenders.EmptyExpressionExtender;

/*
 * Represents a closed parenthesis expression that has a complete expression inside it.
 * e.g. (12), (1 + 2), (3 * 4)
 */
class ClosedPExpression extends CompleteExpression {
    private CompleteExpression innerExpression;

    public ClosedPExpression(CompleteExpression innerExpression) {
        super(new EmptyExpressionExtender());
        this.innerExpression = innerExpression;
    }

    @Override
    public NumberValue eval() {
        return innerExpression.eval();
    }

    @Override
    public String toString() {
        return "CLOSED PAREN EXPRESSION";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(innerExpression);
        return children;
    }
}
