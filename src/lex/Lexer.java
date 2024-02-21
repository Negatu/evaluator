package evaluator.lex;

import java.util.ArrayList;

import evaluator.tokens.Token;

public class Lexer {
    private String input;

    public Lexer(String input) {
        this.input = input;
    }

    public ArrayList<Token> getTokens() {
        if (input.length() == 0) {
            return new ArrayList<Token>();
        }
        Token lastToken = Tokenizer.tokenize(input.charAt(0));
        ArrayList<Token> tokens = new ArrayList<Token>();
        tokens.add(lastToken);

        for (int i = 1; i < input.length(); i++) {
            char letter = input.charAt(i);
            // try extending the last token or create a new one
            if (!lastToken.extend(letter)) {
                lastToken = Tokenizer.tokenize(letter);
                tokens.add(lastToken);
            }
        }
        return tokens;
    }
}
