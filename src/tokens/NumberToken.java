package evaluator.tokens;

public class NumberToken extends Token {
    private double number;
    private int decimalDivisor;
    private boolean hasDecimal;

    public NumberToken(int wholePart) {
        super(String.valueOf(wholePart), TokenType.NUMBER);
        this.number = wholePart;
        this.decimalDivisor = 10;
        this.hasDecimal = false;
    }

    @Override
    public boolean extend(char letter) {
        if (letter == '.' && !hasDecimal) {
            hasDecimal = true;
            extendText(letter);
            return true;
        }

        if (!Character.isDigit(letter)) {
            return false;
        }

        if (hasDecimal) {
            number += Character.getNumericValue(letter) / (double) decimalDivisor;
            decimalDivisor *= 10;
        } else {
            number = number * 10 + Character.getNumericValue(letter);
        }

        extendText(letter);
        return true;
    }

    public double getNumber() {
        return number;
    }
}