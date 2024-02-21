package evaluator.lex;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;

import evaluator.lex.Lexer;
import evaluator.tokens.Token;
import evaluator.tokens.NumberToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.WhitespaceToken;

public class LexerTest {

    @Test
    public void getTokens_with_empty_input_returns_empty() {
        Lexer lexer = new Lexer("");
        ArrayList<Token> tokens = lexer.getTokens();
        assertThat(tokens).isEmpty();
    }

    @Test
    public void getTokens_with_single_input_returns_corresponding_token() {
        Lexer lexer = new Lexer("1");
        ArrayList<Token> tokens = lexer.getTokens();
        assertThat(tokens).hasSize(1);
        assertThat(tokens.get(0)).isInstanceOf(NumberToken.class);
    }

    @Test
    public void getTokens_with_multiple_inputs_returns_corresponding_tokens() {
        Lexer lexer = new Lexer("1 + 2");
        ArrayList<Token> tokens = lexer.getTokens();
        assertThat(tokens).hasSize(5);
        assertThat(tokens.get(0)).isInstanceOf(NumberToken.class);
        assertThat(tokens.get(1)).isInstanceOf(WhitespaceToken.class);
        assertThat(tokens.get(2)).isInstanceOf(PlusToken.class);
        assertThat(tokens.get(3)).isInstanceOf(WhitespaceToken.class);
        assertThat(tokens.get(4)).isInstanceOf(NumberToken.class);
    }
}
