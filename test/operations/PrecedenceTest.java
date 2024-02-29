package evaluator.operations;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PrecedenceTest {

    @Test
    public void times_operation_has_higher_precedence_than_plus_operation() {
        BinaryOperation timesOperation = new BinaryTimesOperation();
        BinaryOperation plusOperation = new BinaryPlusOperation();
        assertThat(Precedence.of(timesOperation)).isGreaterThan(Precedence.of(plusOperation));
    }

    @Test
    public void times_operation_has_higher_precedence_than_minus_operation() {
        BinaryOperation timesOperation = new BinaryTimesOperation();
        BinaryOperation minusOperation = new BinaryMinusOperation();
        assertThat(Precedence.of(timesOperation)).isGreaterThan(Precedence.of(minusOperation));
    }

    @Test
    public void divide_operation_has_higher_precedence_than_plus_operation() {
        BinaryOperation divideOperation = new BinaryDivideOperation();
        BinaryOperation plusOperation = new BinaryPlusOperation();
        assertThat(Precedence.of(divideOperation)).isGreaterThan(Precedence.of(plusOperation));
    }

    @Test
    public void divide_operation_has_higher_precedence_than_minus_operation() {
        BinaryOperation divideOperation = new BinaryDivideOperation();
        BinaryOperation minusOperation = new BinaryMinusOperation();
        assertThat(Precedence.of(divideOperation)).isGreaterThan(Precedence.of(minusOperation));
    }

}
