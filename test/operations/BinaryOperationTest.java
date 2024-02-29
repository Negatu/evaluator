package evaluator.operations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import evaluator.values.NumberValue;
import evaluator.tokens.PlusToken;
import evaluator.tokens.TimesToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.OpToken;
import evaluator.tokens.ForwardSlashToken;
import evaluator.tokens.EOFToken;

public class BinaryOperationTest {

    @Test
    public void fromPlusToken_returnsBinaryPlusOperation() {
        BinaryOperation operation = BinaryOperation.from(new PlusToken());
        assertThat(operation).isInstanceOf(BinaryPlusOperation.class);
        assertThat(operation.eval(new NumberValue(12), new NumberValue(13)).getNumber()).isEqualTo(25);
    }

    @Test
    public void fromTimesToken_returnsBinaryTimesOperation() {
        BinaryOperation operation = BinaryOperation.from(new TimesToken());
        assertThat(operation).isInstanceOf(BinaryTimesOperation.class);
        assertThat(operation.eval(new NumberValue(12), new NumberValue(13)).getNumber()).isEqualTo(156);
    }

    @Test
    public void fromMinusToken_returnsBinaryMinusOperation() {
        BinaryOperation operation = BinaryOperation.from(new MinusToken());
        assertThat(operation).isInstanceOf(BinaryMinusOperation.class);
        assertThat(operation.eval(new NumberValue(14), new NumberValue(5)).getNumber()).isEqualTo(9);
    }

    @Test
    public void fromForwardSlashToken_returnsBinaryDivideOperation() {
        BinaryOperation operation = BinaryOperation.from(new ForwardSlashToken());
        assertThat(operation).isInstanceOf(BinaryDivideOperation.class);
        assertThat(operation.eval(new NumberValue(15), new NumberValue(5)).getNumber()).isEqualTo(3);
    }

    @Test
    public void fromUnknownToken_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            BinaryOperation.from(mock(OpToken.class));
        });
    }

}
