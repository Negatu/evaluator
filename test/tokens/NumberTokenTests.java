package evaluator.tokens;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberTokenTests {

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
}
