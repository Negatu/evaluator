package evaluator.operations;

import java.util.ArrayList;

import evaluator.SyntaxNode;
import evaluator.tokens.OpToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.MinusToken;
import evaluator.values.NumberValue;

public abstract class UnaryOperation extends Operation {
    abstract public NumberValue eval(NumberValue value);

    public static UnaryOperation from(OpToken token) {
        if (token instanceof PlusToken) {
            return new UnaryPlusOperation();
        } else if (token instanceof MinusToken) {
            return new UnaryMinusOperation();
        } else {
            throw new IllegalArgumentException(
                    String.format("Unable to create unary operation from token '%s'", token));
        }
    }
}