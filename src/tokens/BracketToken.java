package evaluator.tokens;

abstract class BracketToken extends Token {
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    public BracketToken(String text, TokenType type) {
        super(text, type);
    }
}

class LeftBracketToken extends BracketToken {
    public LeftBracketToken() {
        super(LEFT_BRACKET, TokenType.LEFT_BRACKET);
    }
}

class RightBracketToken extends BracketToken {
    public RightBracketToken() {
        super(RIGHT_BRACKET, TokenType.RIGHT_BRACKET);
    }
}
