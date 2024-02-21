package evaluator.tokens;

public class NumberToken extends Token {
    private int number;

    public NumberToken(int number) {
        super(String.valueOf(number), TokenType.NUMBER);
        this.number = number;
    }

    @Override
    public boolean extend(char letter) {
        if (!Character.isDigit(letter)) {
            return false;
        }

        number = number * 10 + Character.getNumericValue(letter);
        extendText(letter);
        return true;
    }

    @Override
    public String getText() {
        return String.valueOf(number);
    }

    public int getNumber() {
        return number;
    }
}