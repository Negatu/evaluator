package evaluator.expressions.incomplete_expressions;

import java.util.ArrayList;

import evaluator.expressions.extenders.UnaryRincExtender;
import evaluator.SyntaxNode;
import evaluator.operations.UnaryOperation;
import evaluator.tokens.OpToken;

/*
 * Represents an incomplete expression with a unary operation. 
 * Rinc stands for right incomplete. Expressions are written from left to right, and this expression is incomplete from the right.
 * e.g. - , - 5 + , - (5 * 3) +
 */
public class UnaryRincExpression extends IncompleteExpression {
    private UnaryOperation operation;
    private IncompleteExpression incompleteOperand;

    public static UnaryRincExpression from(OpToken token) {
        return new UnaryRincExpression(UnaryOperation.from(token));
    }

    public UnaryRincExpression(UnaryOperation operation) {
        super(new UnaryRincExtender());
        this.operation = operation;
        incompleteOperand = new EmptyExpression();
    }

    public UnaryRincExpression(UnaryOperation operation, IncompleteExpression incompleteOperand) {
        super(new UnaryRincExtender());
        this.operation = operation;
        this.incompleteOperand = incompleteOperand;
    }

    public UnaryOperation getOperation() {
        return operation;
    }

    public IncompleteExpression getOperand() {
        return incompleteOperand;
    }

    @Override
    public String toString() {
        return "UNARY RINC EXPRESSION";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(operation);
        children.add(incompleteOperand);
        return children;
    }
}