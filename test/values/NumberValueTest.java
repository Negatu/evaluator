package evaluator.values;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberValueTest {

    @Test
    public void equals_whenSameNumber_returnsTrue() {
        NumberValue numberValue = new NumberValue(5);
        NumberValue other = new NumberValue(5);
        assertThat(numberValue.equals(other)).isTrue();
    }

    @Test
    public void equals_whenDifferentNumber_returnsFalse() {
        NumberValue numberValue = new NumberValue(5);
        NumberValue other = new NumberValue(6);
        assertThat(numberValue.equals(other)).isFalse();
    }
}