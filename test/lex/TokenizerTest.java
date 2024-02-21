package evaluator.lex;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import evaluator.tokens.Token;
import evaluator.tokens.TokenType;
import evaluator.tokens.NumberToken;
import evaluator.tokens.WhitespaceToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.TimesToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.RightBracketToken;

public class TokenizerTest {

    @Test
    public void tokenize_digit_char_returns_number_token() {
        Token token = Tokenizer.tokenize('1');
        assertThat(token).isInstanceOf(NumberToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.NUMBER);
    }

    @Test
    public void tokenize_whitespace_char_returns_whitespace_token() {
        Token token = Tokenizer.tokenize(' ');
        assertThat(token).isInstanceOf(WhitespaceToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.WHITESPACE);
    }

    @Test
    public void tokenize_plus_char_returns_plus_token() {
        Token token = Tokenizer.tokenize('+');
        assertThat(token).isInstanceOf(PlusToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.PLUS);
    }

    @Test
    public void tokenize_star_char_returns_times_token() {
        Token token = Tokenizer.tokenize('*');
        assertThat(token).isInstanceOf(TimesToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.STAR);
    }

    @Test
    public void tokenize_dash_char_returns_minus_token() {
        Token token = Tokenizer.tokenize('-');
        assertThat(token).isInstanceOf(MinusToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.DASH);
    }

    @Test
    public void tokenize_left_bracket_char_returns_left_bracket_token() {
        Token token = Tokenizer.tokenize('(');
        assertThat(token).isInstanceOf(LeftBracketToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.LEFT_BRACKET);
    }

    @Test
    public void tokenize_right_bracket_char_returns_right_bracket_token() {
        Token token = Tokenizer.tokenize(')');
        assertThat(token).isInstanceOf(RightBracketToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.RIGHT_BRACKET);
    }

    @Test
    public void tokenize_unknown_char_throws_exception() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Tokenizer.tokenize('%');
        });

        assertThat(exception.getMessage()).isEqualTo("Unable to tokenize character '%'");

    }

}
