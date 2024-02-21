package evaluator.tokens;

enum TokenType {
    NUMBER, WHITESPACE, PLUS, STAR, DASH, EOF,
    LEFT_BRACKET, RIGHT_BRACKET
}

abstract class Token {
    private String text;
    private TokenType type;

    public Token(String text, TokenType type) {
        this.text = text;
        this.type = type;
    }

    /*
     * Returns true if the token can be extended with the letter, false otherwise
     */
    public boolean extend(char letter) {
        return false;
    }

    /*
     * Returns the text value of the token
     */
    public String getText() {
        return text;
    }

    protected void extendText(char letter) {
        text += letter;
    }

    protected void replaceText(String text) {
        this.text = text;
    }

    public TokenType getType() {
        return type;
    }
}
