package evaluator;

import java.util.ArrayList;

/*
 * This interface is used to represent a node in the parse tree. 
 */
interface SyntaxNode {
    public String printRepr();

    public ArrayList<SyntaxNode> getChildren();
}