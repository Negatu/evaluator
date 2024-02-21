package evaluator.tokens;

public class PlusToken extends OpToken {
    public static final String PLUS_SYMBOL = "+";

    public PlusToken() {
        super(PLUS_SYMBOL, TokenType.PLUS);
    }
}