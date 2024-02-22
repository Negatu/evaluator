package evaluator.operations;

import evaluator.expressions.values.NumberValue;
import evaluator.tokens.OpToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.TimesToken;

public abstract class BinaryOperation extends Operation {
    abstract public NumberValue eval(NumberValue left, NumberValue right);

    public static BinaryOperation from(OpToken token) {
        if (token instanceof PlusToken) {
            return new BinaryPlusOperation();
        } else if (token instanceof TimesToken) {
            return new BinaryTimesOperation();
        } else if (token instanceof MinusToken) {
            return new BinaryMinusOperation();
        } else {
            throw new IllegalArgumentException(String.format("Unknown binary operation token: %s", token));
        }
    }
}