package evaluator.operations;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PrecedenceTest {

    @Test
    public void timesOperation_hasHigherPrecedence_thanPlusOperation() {
        BinaryOperation timesOperation = new BinaryTimesOperation();
        BinaryOperation plusOperation = new BinaryPlusOperation();
        assertThat(Precedence.of(timesOperation)).isGreaterThan(Precedence.of(plusOperation));
    }

    @Test
    public void timesOperation_hasHigherPrecedence_thanMinusOperation() {
        BinaryOperation timesOperation = new BinaryTimesOperation();
        BinaryOperation minusOperation = new BinaryMinusOperation();
        assertThat(Precedence.of(timesOperation)).isGreaterThan(Precedence.of(minusOperation));
    }

    @Test
    public void divideOperation_hasHigherPrecedence_thanPlusOperation() {
        BinaryOperation divideOperation = new BinaryDivideOperation();
        BinaryOperation plusOperation = new BinaryPlusOperation();
        assertThat(Precedence.of(divideOperation)).isGreaterThan(Precedence.of(plusOperation));
    }

    @Test
    public void divideOperation_hasHigherPrecedence_thanMinusOperation() {
        BinaryOperation divideOperation = new BinaryDivideOperation();
        BinaryOperation minusOperation = new BinaryMinusOperation();
        assertThat(Precedence.of(divideOperation)).isGreaterThan(Precedence.of(minusOperation));
    }

    @Test
    public void exponent_hasHigherPrecedence_thanDivideOperation() {
        BinaryOperation exponentOperation = new ExponentOperation();
        BinaryOperation divideOperation = new BinaryDivideOperation();
        assertThat(Precedence.of(exponentOperation)).isGreaterThan(Precedence.of(divideOperation));
    }

}
