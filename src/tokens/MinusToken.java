package evaluator.tokens;

public class MinusToken extends OpToken {
    public static final String DASH_SYMBOL = "-";

    public MinusToken() {
        super(DASH_SYMBOL, TokenType.DASH);
    }
}
