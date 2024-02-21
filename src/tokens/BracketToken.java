package evaluator.tokens;

public abstract class BracketToken extends Token {

    public BracketToken(String text, TokenType type) {
        super(text, type);
    }
}