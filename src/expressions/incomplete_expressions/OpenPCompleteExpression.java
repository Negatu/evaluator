package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;
import evaluator.expressions.extenders.EmptyExpressionExtender;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.values.NumberValue;
import evaluator.SyntaxNode;

/*
 * Represents an open parenthesis expression that has a complete expression inside it.
 * e.g. (12, (1 + 2, (3 * 4
 */
public class OpenPCompleteExpression extends IncompleteExpression {
    private CompleteExpression innerExpression;

    public OpenPCompleteExpression(CompleteExpression innerExpression) {
        super(new EmptyExpressionExtender());
        this.innerExpression = innerExpression;
    }

    public CompleteExpression getInnerExpression() {
        return innerExpression;
    }

    @Override
    public NumberValue eval() {
        return innerExpression.eval();
    }

    @Override
    public String toString() {
        return "OPEN PAREN COMPLETE EXPRESSION";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(innerExpression);
        return children;
    }
}