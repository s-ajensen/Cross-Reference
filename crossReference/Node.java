package crossReference;

import java.util.ArrayList;

public class Node {

    String element;
    public ArrayList<Integer> occurrences;
    Node left;
    Node right;

    public Node(String element) {
        this.element = element;
        this.left = null;
        this.right = null;
        this.occurrences = new ArrayList<>();
    }

    public Node getLeft() {
        return(this.left);
    }

    public Node getRight() {
        return(this.right);
    }

    public String getElement() {
        return(this.element);
    }

    public void setElement(String element) {
        this.element = element;
    }
}
