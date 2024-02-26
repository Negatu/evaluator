package evaluator;

import java.util.ArrayList;

import evaluator.expressions.Expression;
import evaluator.expressions.incomplete_expressions.EmptyExpression;
import evaluator.tokens.Token;
import evaluator.tokens.WhitespaceToken;
import evaluator.lex.Lexer;
import evaluator.values.NumberValue;

/*
 * The Evaluator class is responsible for evaluating mathematical expressions in a string format.
 * It uses a Lexer to tokenize the input string and an Expression to parse and evaluate the tokens.
 * The result of the evaluation is returned as a NumberExpression.
 */
public class Evaluator {

    public Evaluator() {
    }

    /*
     * Evaluates a mathematical expression in a string format and returns the result
     * of evaluating the expression.
     * 
     * 
     * @param input The mathematical expression to be evaluated.
     * 
     * @return The numerical result of evaluating the expression.
     */
    public NumberValue evaluate(String input) {
        Lexer lexer = new Lexer(input);
        ArrayList<Token> tokens = lexer.getTokens();
        Expression expression = new EmptyExpression();
        for (Token token : tokens) {
            if (token instanceof WhitespaceToken) {
                continue;
            }
            expression = expression.extend(token);
        }
        return expression.eval();
    }

}
