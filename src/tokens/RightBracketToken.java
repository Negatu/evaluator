package evaluator.tokens;

public class RightBracketToken extends BracketToken {
    public static final String RIGHT_BRACKET = ")";

    public RightBracketToken() {
        super(RIGHT_BRACKET, TokenType.RIGHT_BRACKET);
    }
}
