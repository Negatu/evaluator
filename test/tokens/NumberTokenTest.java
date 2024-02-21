package evaluator.tokens;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberTokenTest {

    @Test
    public void extend_with_digit_extends_token() {
        NumberToken token = new NumberToken(1);
        boolean token_extended = token.extend('2');
        assertThat(token_extended).isTrue();
        assertThat(token.getText()).isEqualTo("12");
    }

    @Test
    public void extend_with_non_digit_returns_false() {
        NumberToken token = new NumberToken(1);
        boolean token_extended = token.extend('a');
        assertThat(token_extended).isFalse();
        assertThat(token.getText()).isEqualTo("1");
    }

    @Test
    public void multiple_extends_with_digits_extends_token() {
        NumberToken token = new NumberToken(1);
        boolean extended_with_2 = token.extend('2');
        boolean extended_with_3 = token.extend('3');
        assertThat(extended_with_2).isTrue();
        assertThat(extended_with_3).isTrue();
        assertThat(token.getText()).isEqualTo("123");
    }
}
