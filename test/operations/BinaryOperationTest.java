package evaluator.operations;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import evaluator.expressions.values.NumberValue;
import evaluator.tokens.PlusToken;
import evaluator.tokens.TimesToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.EOFToken;

public class BinaryOperationTest {

    @Test
    public void binary_operation_from_plus_token_returns_binary_plus_operation() {
        BinaryOperation operation = BinaryOperation.from(new PlusToken());
        assertThat(operation).isInstanceOf(BinaryPlusOperation.class);
        assertThat(operation.eval(new NumberValue(12), new NumberValue(13)).getNumber()).isEqualTo(25);
    }

    @Test
    public void binary_operation_from_times_token_returns_binary_times_operation() {
        BinaryOperation operation = BinaryOperation.from(new TimesToken());
        assertThat(operation).isInstanceOf(BinaryTimesOperation.class);
        assertThat(operation.eval(new NumberValue(12), new NumberValue(13)).getNumber()).isEqualTo(156);
    }

    @Test
    public void binary_operation_from_minus_token_returns_binary_minus_operation() {
        BinaryOperation operation = BinaryOperation.from(new MinusToken());
        assertThat(operation).isInstanceOf(BinaryMinusOperation.class);
        assertThat(operation.eval(new NumberValue(14), new NumberValue(5)).getNumber()).isEqualTo(9);
    }

}
