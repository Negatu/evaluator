package evaluator.operations;

import java.util.ArrayList;

import evaluator.values.NumberValue;
import evaluator.SyntaxNode;

public class BinaryTimesOperation extends BinaryOperation {
    @Override
    public NumberValue eval(NumberValue left, NumberValue right) {
        return new NumberValue(left.getNumber() * right.getNumber());
    }

    @Override
    public String toString() {
        return "BINARY TIMES OP";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }
}