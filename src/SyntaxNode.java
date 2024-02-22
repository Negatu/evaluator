package evaluator;

import java.util.ArrayList;

/*
 * This interface is used to represent a node in the parse tree. 
 */
public interface SyntaxNode {

    /*
     * Returns a list of the children of this node.
     */
    public ArrayList<SyntaxNode> getChildren();

    /*
     * Returns a string representation of this node.
     */
    public String toString();
}