package evaluator.operations;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.tokens.OpToken;
import evaluator.tokens.MinusToken;
import evaluator.values.NumberValue;

public class UnaryMinusOperation extends UnaryOperation {
    @Override
    public NumberValue eval(NumberValue value) {
        return new NumberValue(-value.getNumber());
    }

    @Override
    public String toString() {
        return "UNARY MINUS OP";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }
}