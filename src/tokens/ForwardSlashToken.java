package evaluator.tokens;

public class ForwardSlashToken extends OpToken {
    public static final String FORWARD_SLASH_SYMBOL = "/";

    public ForwardSlashToken() {
        super(FORWARD_SLASH_SYMBOL, TokenType.FORWARD_SLASH);
    }
}