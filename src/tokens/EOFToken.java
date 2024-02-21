package evaluator.tokens;

public class EOFToken extends Token {
    public static final String EMPTY_STRING = "";

    public EOFToken() {
        super(EMPTY_STRING, TokenType.EOF);
    }
}