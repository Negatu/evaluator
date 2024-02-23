package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;
import evaluator.SyntaxNode;
import evaluator.expressions.extenders.EmptyExpressionExtender;

/*
 * Represents an open parenthesis expression that has an incomplete expression inside it.
 */
public class OpenPRincExpression extends IncompleteExpression {
    private IncompleteExpression innerExpression;

    public OpenPRincExpression(IncompleteExpression innerExpression) {
        super(new EmptyExpressionExtender());
        this.innerExpression = innerExpression;
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(innerExpression);
        return children;
    }
}