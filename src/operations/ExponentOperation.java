package evaluator.operations;

import java.lang.Math;
import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.values.NumberValue;

public class ExponentOperation extends BinaryOperation {
    public ExponentOperation() {
    }

    @Override
    public NumberValue eval(NumberValue left, NumberValue right) {
        return new NumberValue(Math.pow(left.getNumber(), right.getNumber()));
    }

    @Override
    public String toString() {
        return "EXPONENT OP";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }

}
