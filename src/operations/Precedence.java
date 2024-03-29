package evaluator.operations;

import evaluator.operations.BinaryOperation;
import evaluator.operations.BinaryPlusOperation;
import evaluator.operations.BinaryTimesOperation;
import evaluator.operations.BinaryMinusOperation;

public class Precedence {
    public static int of(BinaryOperation operation) {
        if (operation instanceof ExponentOperation) {
            return 3;
        } else if (operation instanceof BinaryTimesOperation) {
            return 2;
        } else if (operation instanceof BinaryDivideOperation) {
            return 2;
        } else if (operation instanceof BinaryPlusOperation) {
            return 1;
        } else if (operation instanceof BinaryMinusOperation) {
            return 1;
        } else {
            throw new IllegalArgumentException(
                    String.format("Unable to determine precedence of operation '%s'", operation));
        }
    }

}