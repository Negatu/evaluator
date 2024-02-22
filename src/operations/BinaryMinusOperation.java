package evaluator.operations;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.expressions.values.NumberValue;

public class BinaryMinusOperation extends BinaryOperation {
    public BinaryMinusOperation() {
    }

    @Override
    public NumberValue eval(NumberValue left, NumberValue right) {
        return new NumberValue(left.getNumber() - right.getNumber());
    }

    @Override
    public String toString() {
        return "BINARY MINUS OP";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }
}
