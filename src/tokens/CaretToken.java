package evaluator.tokens;

public class CaretToken extends OpToken {
    public static final String CARET_SYMBOL = "^";

    public CaretToken() {
        super(CARET_SYMBOL, TokenType.CARET);
    }
}