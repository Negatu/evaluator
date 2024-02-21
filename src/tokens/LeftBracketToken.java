package evaluator.tokens;

public class LeftBracketToken extends BracketToken {
    public static final String LEFT_BRACKET = "(";

    public LeftBracketToken() {
        super(LEFT_BRACKET, TokenType.LEFT_BRACKET);
    }
}