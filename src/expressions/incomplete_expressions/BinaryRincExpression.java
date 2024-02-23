package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.expressions.complete_expressions.CompleteExpression;
import evaluator.expressions.extenders.EmptyExpressionExtender;
import evaluator.operations.BinaryOperation;

/*
 * Represents an incomplete expression with a binary operation. 
 * Rinc stands for right incomplete. Expressions are written from left to right, and this expression has an incomplete right operand.
 * e.g. 5 + , (5 * 3) + , 5 + (5 * 3) +
 */
public class BinaryRincExpression extends IncompleteExpression {
    private BinaryOperation operation;
    private CompleteExpression left;
    private IncompleteExpression right;

    public BinaryRincExpression(BinaryOperation operation, CompleteExpression left, IncompleteExpression right) {
        super(new EmptyExpressionExtender());
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public BinaryOperation getOperation() {
        return operation;
    }

    public CompleteExpression getLeft() {
        return left;
    }

    public IncompleteExpression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "BINARY RINC EXPRESSION";
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