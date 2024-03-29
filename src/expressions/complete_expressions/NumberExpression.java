package evaluator.expressions.complete_expressions;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.expressions.extenders.CompleteExpressionExtender;
import evaluator.values.NumberValue;

public class NumberExpression extends CompleteExpression {
    private double number;

    public NumberExpression(double number) {
        super(new CompleteExpressionExtender());
        this.number = number;
    }

    @Override
    public NumberValue eval() {
        return new NumberValue(number);
    }

    @Override
    public String toString() {
        return "NUMBER " + Double.toString(number);
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        // A NumberExpression is a leaf node in the parse tree, so it has no children.
        return new ArrayList<SyntaxNode>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NumberExpression other = (NumberExpression) obj;
        return number == other.number;
    }
}