package evaluator.tokens;

public class TimesToken extends OpToken {
    public static final String STAR_SYMBOL = "*";

    public TimesToken() {
        super(STAR_SYMBOL, TokenType.STAR);
    }
}