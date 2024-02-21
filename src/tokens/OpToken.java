package evaluator.tokens;

public abstract class OpToken extends Token {

    public OpToken(String text, TokenType type) {
        super(text, type);
    }
}