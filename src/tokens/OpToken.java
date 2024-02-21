package evaluator.tokens;

abstract class OpToken extends Token {
    public static final String PLUS_SYMBOL = "+";
    public static final String STAR_SYMBOL = "*";
    public static final String DASH_SYMBOL = "-";

    public OpToken(String text, TokenType type) {
        super(text, type);
    }
}

class PlusToken extends OpToken {
    public PlusToken() {
        super(PLUS_SYMBOL, TokenType.PLUS);
    }
}

class TimesToken extends OpToken {
    public TimesToken() {
        super(STAR_SYMBOL, TokenType.STAR);
    }
}

class MinusToken extends OpToken {
    public MinusToken() {
        super(DASH_SYMBOL, TokenType.DASH);
    }
}
