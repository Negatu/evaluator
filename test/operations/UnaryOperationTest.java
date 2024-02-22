package evaluator.operations;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import evaluator.values.NumberValue;
import evaluator.tokens.PlusToken;
import evaluator.tokens.MinusToken;

public class UnaryOperationTest {

    @Test
    public void unary_operation_from_plus_token_returns_unary_plus_operation() {
        UnaryOperation operation = UnaryOperation.from(new PlusToken());
        assertThat(operation).isInstanceOf(UnaryPlusOperation.class);
        assertThat(operation.eval(new NumberValue(12)).getNumber()).isEqualTo(12);
    }

    @Test
    public void unary_operation_from_minus_token_returns_unary_minus_operation() {
        UnaryOperation operation = UnaryOperation.from(new MinusToken());
        assertThat(operation).isInstanceOf(UnaryMinusOperation.class);
        assertThat(operation.eval(new NumberValue(14)).getNumber()).isEqualTo(-14);
    }

}
