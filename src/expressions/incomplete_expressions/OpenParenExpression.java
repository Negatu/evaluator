package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;
import evaluator.expressions.extenders.OpenParenExtender;
import evaluator.expressions.Expression;
import evaluator.values.NumberValue;
import evaluator.SyntaxNode;

/*
 * Represents an open parenthesis expression that has another inner expression that it holds
 * e.g. (12, (1 + 2, (3 * 4
 */
public class OpenParenExpression extends IncompleteExpression {
    private Expression innerExpression;

    public OpenParenExpression(Expression innerExpression) {
        super(new OpenParenExtender());
        this.innerExpression = innerExpression;
    }

    public Expression getInnerExpression() {
        return innerExpression;
    }

    @Override
    public String toString() {
        return "OPEN PAREN EXPRESSION";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(innerExpression);
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OpenParenExpression that = (OpenParenExpression) o;
        return innerExpression.equals(that.getInnerExpression());
    }
}