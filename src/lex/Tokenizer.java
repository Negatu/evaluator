package evaluator.lex;

import evaluator.tokens.Token;
import evaluator.tokens.NumberToken;
import evaluator.tokens.WhitespaceToken;
import evaluator.tokens.PlusToken;
import evaluator.tokens.TimesToken;
import evaluator.tokens.MinusToken;
import evaluator.tokens.LeftBracketToken;
import evaluator.tokens.RightBracketToken;
import evaluator.tokens.TokenType;
import evaluator.tokens.BracketToken;
import evaluator.tokens.EOFToken;
import evaluator.tokens.ForwardSlashToken;

class Tokenizer {

    public static Token tokenize(char c) {
        if (Character.isDigit(c)) {
            return new NumberToken(Character.getNumericValue(c));
        } else if (Character.isWhitespace(c)) {
            return new WhitespaceToken();
        } else if (String.valueOf(c).equals(PlusToken.PLUS_SYMBOL)) {
            return new PlusToken();
        } else if (String.valueOf(c).equals(TimesToken.STAR_SYMBOL)) {
            return new TimesToken();
        } else if (String.valueOf(c).equals(MinusToken.DASH_SYMBOL)) {
            return new MinusToken();
        } else if (String.valueOf(c).equals(ForwardSlashToken.FORWARD_SLASH_SYMBOL)) {
            return new ForwardSlashToken();
        } else if (String.valueOf(c).equals(LeftBracketToken.LEFT_BRACKET)) {
            return new LeftBracketToken();
        } else if (String.valueOf(c).equals(RightBracketToken.RIGHT_BRACKET)) {
            return new RightBracketToken();
        } else {
            throw new IllegalArgumentException(String.format("Unable to tokenize character '%c'", c));
        }
    }
}
