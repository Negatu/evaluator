package evaluator.operations;

import java.util.ArrayList;

import evaluator.expressions.values.NumberValue;
import evaluator.SyntaxNode;

public class BinaryPlusOperation extends BinaryOperation {
    @Override
    public NumberValue eval(NumberValue left, NumberValue right) {
        return new NumberValue(left.getNumber() + right.getNumber());
    }

    @Override
    public String toString() {
        return "BINARY PLUS OP";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }
}