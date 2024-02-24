package evaluator.expressions.complete_expressions;

import java.util.ArrayList;

import evaluator.expressions.extenders.CompleteExpressionExtender;
import evaluator.values.NumberValue;
import evaluator.operations.UnaryOperation;
import evaluator.SyntaxNode;

public class UnaryExpression extends CompleteExpression {
    private UnaryOperation operation;
    private CompleteExpression operand;

    public UnaryExpression(UnaryOperation operation, CompleteExpression operand) {
        super(new CompleteExpressionExtender());
        this.operation = operation;
        this.operand = operand;
    }

    @Override
    public NumberValue eval() {
        NumberValue result = operand.eval();
        return operation.eval(result);
    }

    @Override
    public String toString() {
        return "UNARY EXPRESSION ";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        ArrayList<SyntaxNode> children = new ArrayList<SyntaxNode>();
        children.add(operation);
        children.add(operand);
        return children;
    }

}