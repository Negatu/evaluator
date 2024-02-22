package evaluator.operations;

import java.util.ArrayList;

import evaluator.SyntaxNode;

public abstract class Operation implements SyntaxNode {
    @Override
    public ArrayList<SyntaxNode> getChildren() {
        // operations do not have children
        return new ArrayList<SyntaxNode>();
    }

    public abstract String toString();

}