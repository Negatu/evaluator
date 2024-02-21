package evaluator.tokens;

public class WhitespaceToken extends Token {
    public static final String WHITESPACE = " ";
    private int length = 0;

    public WhitespaceToken() {
        super(WHITESPACE, TokenType.WHITESPACE);
        length = 1;
    }

    public static String whitespaceOfLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public boolean extend(char letter) {
        if (!Character.isWhitespace(letter)) {
            return false;
        }
        length++;
        return true;
    }

    @Override
    public String getText() {
        return whitespaceOfLength(length);
    }

}
