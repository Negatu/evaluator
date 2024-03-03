package evaluator.operations;

import evaluator.values.NumberValue;
import evaluator.tokens.OpToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.TimesToken;
import evaluator.tokens.ForwardSlashToken;
import evaluator.tokens.CaretToken;

public abstract class BinaryOperation extends Operation {
    abstract public NumberValue eval(NumberValue left, NumberValue right);

    public static BinaryOperation from(OpToken token) {
        if (token instanceof PlusToken) {
            return new BinaryPlusOperation();
        } else if (token instanceof TimesToken) {
            return new BinaryTimesOperation();
        } else if (token instanceof MinusToken) {
            return new BinaryMinusOperation();
        } else if (token instanceof ForwardSlashToken) {
            return new BinaryDivideOperation();
        } else if (token instanceof CaretToken) {
            return new ExponentOperation();
        } else {
            throw new IllegalArgumentException(String.format("Unknown binary operation token: %s", token));
        }
    }
}