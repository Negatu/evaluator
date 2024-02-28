package evaluator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import evaluator.values.NumberValue;

public class EvaluatorTest {
    private Evaluator evaluator;

    @Before
    public void setUp() {
        evaluator = new Evaluator();
    }

    @Test
    public void evaluate_addsTwoNumbers() {
        String input = "1 + 2";
        NumberValue expectedResult = new NumberValue(3);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenMultipleOperations_returnsCorrectResult() {
        String input = "13 - 4 + 6 - 1";
        NumberValue expectedResult = new NumberValue(14);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenMultipleUnaryOperations_returnsCorrectResult() {
        String input = "---++-+-6";
        NumberValue expectedResult = new NumberValue(-6);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenUnaryAndBinaryOperation_returnsCorrectResult() {
        String input = "-6 + 3 + 15";
        NumberValue expectedResult = new NumberValue(12);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenHigherPrecdenceOpOnTheRight_returnsCorrectResult() {
        String input = "4 + 3 * 5";
        NumberValue expectedResult = new NumberValue(19);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenHigherPrecdenceOpOnTheLeft_returnsCorrectResult() {
        String input = "4 * 3 + 5";
        NumberValue expectedResult = new NumberValue(17);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenParenthesizedLowerPrecedenceOP_returnsCorrectResult() {
        String input = "(4 + 3) * 5";
        NumberValue expectedResult = new NumberValue(35);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenComplexParenthesisExpression_returnsCorrectResult() {
        String input = "((((-10 + 2) * (5 - 3)) + ((++8 - 4) * 6)) + (((3 + 7) * (4 - 2)) + ((6 - 2) * 5)))";
        NumberValue expectedResult = new NumberValue(48);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void evaluate_whenDecimalNumbers_returnsCorrectResult() {
        String input = "1.2 + 2.5 * 0.5";
        NumberValue expectedResult = new NumberValue(2.45);

        NumberValue result = evaluator.evaluate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

}
