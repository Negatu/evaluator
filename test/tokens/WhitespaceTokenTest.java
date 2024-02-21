package evaluator.tokens;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WhitespaceTokenTest {

    @Test
    public void extend_with_whitespace_extends_token() {
        WhitespaceToken token = new WhitespaceToken();
        boolean token_extended = token.extend(' ');
        assertThat(token_extended).isTrue();
        assertThat(token.getText()).isEqualTo("  ");
    }

    @Test
    public void extend_with_non_whitespace_returns_false() {
        WhitespaceToken token = new WhitespaceToken();
        boolean token_extended = token.extend('a');
        assertThat(token_extended).isFalse();
        assertThat(token.getText()).isEqualTo(" ");
    }

    @Test
    public void multiple_extends_with_whitespace_extends_token() {
        String three_white_spaces = "   ";
        WhitespaceToken token = new WhitespaceToken();
        boolean extended_with_second_space = token.extend(' ');
        boolean extended_with_third_space = token.extend(' ');
        assertThat(extended_with_second_space).isTrue();
        assertThat(extended_with_third_space).isTrue();
        assertThat(token.getText()).isEqualTo(three_white_spaces);
    }

}
