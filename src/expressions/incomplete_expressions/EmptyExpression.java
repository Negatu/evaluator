package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.expressions.extenders.EmptyExpressionExtender;

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
}