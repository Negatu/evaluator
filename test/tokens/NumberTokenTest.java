package evaluator.tokens;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberTokenTest {

    @Test
    public void extend_withDigit_extendsNumberToken() {
        NumberToken token = new NumberToken(1);
        boolean token_extended = token.extend('2');
        assertThat(token_extended).isTrue();
        assertThat(token.getNumber()).isEqualTo(12);
        assertThat(token.getText()).isEqualTo("12");
    }

    @Test
    public void extend_withInvalidCharacter_returnsFalse() {
        NumberToken token = new NumberToken(1);
        boolean token_extended = token.extend('a');
        assertThat(token_extended).isFalse();
        assertThat(token.getNumber()).isEqualTo(1);
        assertThat(token.getText()).isEqualTo("1");
    }

    @Test
    public void extend_withConsecutiveDigits_extendsNumberToken() {
        NumberToken token = new NumberToken(1);
        boolean extended_with_2 = token.extend('2');
        boolean extended_with_3 = token.extend('3');
        assertThat(extended_with_2).isTrue();
        assertThat(extended_with_3).isTrue();
        assertThat(token.getNumber()).isEqualTo(123);
        assertThat(token.getText()).isEqualTo("123");
    }

    @Test
    public void extend_withSingleDecimal_extendsNumbertoken() {
        NumberToken token = new NumberToken(1);
        boolean extended_with_dot = token.extend('.');
        boolean extended_with_2 = token.extend('2');
        assertThat(extended_with_dot).isTrue();
        assertThat(extended_with_2).isTrue();
        assertThat(token.getNumber()).isEqualTo(1.2);
        assertThat(token.getText()).isEqualTo("1.2");
    }

    @Test
    public void extend_withConsecutiveDecimalNumbers_extendsNumberToken() {
        NumberToken token = new NumberToken(15);
        boolean extended_with_dot = token.extend('.');
        boolean extended_with_3 = token.extend('3');
        boolean extended_with_9 = token.extend('9');
        assertThat(extended_with_dot).isTrue();
        assertThat(extended_with_3).isTrue();
        assertThat(extended_with_9).isTrue();
        assertThat(token.getNumber()).isEqualTo(15.39);
        assertThat(token.getText()).isEqualTo("15.39");
    }

    @Test
    public void extend_withMultipleDots_returnsFalse() {
        NumberToken token = new NumberToken(1);
        boolean extended_with_dot = token.extend('.');
        boolean extended_with_dot2 = token.extend('.');
        assertThat(extended_with_dot).isTrue();
        assertThat(extended_with_dot2).isFalse();
        assertThat(token.getNumber()).isEqualTo(1);
        assertThat(token.getText()).isEqualTo("1.");
    }
}
