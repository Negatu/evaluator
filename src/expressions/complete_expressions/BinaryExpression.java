package evaluator.expressions.complete_expressions;

import java.util.ArrayList;

import evaluator.expressions.extenders.EmptyExpressionExtender;
import evaluator.operations.BinaryOperation;
import evaluator.SyntaxNode;
import evaluator.values.NumberValue;

/*
 * Represents a binary expression that can be evaluated into a number value.
 */
public class BinaryExpression extends CompleteExpression {
    private BinaryOperation operation;
    private CompleteExpression left;
    private CompleteExpression right;

    public BinaryExpression(BinaryOperation operation, CompleteExpression left,
            CompleteExpression right) {
        super(new EmptyExpressionExtender());
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public BinaryOperation getOperation() {
        return operation;
    }

    public CompleteExpression getRight() {
        return right;
    }

    public CompleteExpression getLeft() {
        return left;
    }

    @Override
    public NumberValue eval() {
        return operation.eval(left.eval(), right.eval());
    }

    @Override
    public String toString() {
        return "BINARY EXPRESSION";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(operation);
        children.add(left);
        children.add(right);
        return children;
    }
}