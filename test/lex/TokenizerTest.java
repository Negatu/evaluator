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
import evaluator.tokens.ForwardSlashToken;
import evaluator.tokens.CaretToken;

public class TokenizerTest {

    @Test
    public void tokenize_withDigit_returnsNumberToken() {
        Token token = Tokenizer.tokenize('1');
        assertThat(token).isInstanceOf(NumberToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.NUMBER);
    }

    @Test
    public void tokenize_withWhitespace_returnsWhitespaceToken() {
        Token token = Tokenizer.tokenize(' ');
        assertThat(token).isInstanceOf(WhitespaceToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.WHITESPACE);
    }

    @Test
    public void tokenize_withPlusChar_returnsPlusToken() {
        Token token = Tokenizer.tokenize('+');
        assertThat(token).isInstanceOf(PlusToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.PLUS);
    }

    @Test
    public void tokenize_withStarChar_returnsTimesToken() {
        Token token = Tokenizer.tokenize('*');
        assertThat(token).isInstanceOf(TimesToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.STAR);
    }

    @Test
    public void tokenize_withDashChar_returnsMinusToken() {
        Token token = Tokenizer.tokenize('-');
        assertThat(token).isInstanceOf(MinusToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.DASH);
    }

    @Test
    public void tokenize_withLeftBracketChar_returnsLeftBracketToken() {
        Token token = Tokenizer.tokenize('(');
        assertThat(token).isInstanceOf(LeftBracketToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.LEFT_BRACKET);
    }

    @Test
    public void tokenize_withRightBracketChar_returnsRightBracketToken() {
        Token token = Tokenizer.tokenize(')');
        assertThat(token).isInstanceOf(RightBracketToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.RIGHT_BRACKET);
    }

    @Test
    public void tokenize_withForwardSlashChar_returnsForwardSlashToken() {
        Token token = Tokenizer.tokenize('/');
        assertThat(token).isInstanceOf(ForwardSlashToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.FORWARD_SLASH);
    }

    @Test
    public void tokenize_withCaretChar_returnsCaretToken() {
        Token token = Tokenizer.tokenize('^');
        assertThat(token).isInstanceOf(CaretToken.class);
        assertThat(token.getType()).isEqualTo(TokenType.CARET);
    }

    @Test
    public void tokenize_withUnkownChar_throwsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Tokenizer.tokenize('%');
        });

        assertThat(exception.getMessage()).isEqualTo("Unable to tokenize character '%'");

    }

}
