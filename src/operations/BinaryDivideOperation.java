package evaluator.operations;

import java.util.ArrayList;

import evaluator.values.NumberValue;
import evaluator.SyntaxNode;

public class BinaryDivideOperation extends BinaryOperation {
    public NumberValue eval(NumberValue left, NumberValue right) {
        return new NumberValue(left.getNumber() / right.getNumber());
    }

    public String toString() {
        return "BINARY DIVIDE OP";
    }

    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }
}