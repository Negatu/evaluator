package evaluator.operations;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.tokens.OpToken;
import evaluator.tokens.PlusToken;
import evaluator.values.NumberValue;

public class UnaryPlusOperation extends UnaryOperation {
    @Override
    public NumberValue eval(NumberValue value) {
        return value;
    }

    @Override
    public String toString() {
        return "UNARY PLUS OP";
    }

    @Override
    public ArrayList<SyntaxNode> getChildren() {
        return new ArrayList<SyntaxNode>();
    }
}