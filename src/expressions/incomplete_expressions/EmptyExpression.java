package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.expressions.extenders.EmptyExpressionExtender;

/*
 * Represents an empty expression that doesn't contain any fields.
 */
public class EmptyExpression extends IncompleteExpression {

    public EmptyExpression() {
        super(new EmptyExpressionExtender());
    }

    @Override
    public String toString() {
        return "EMPTY EXPRESSION";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && getClass() == obj.getClass();
    }
}