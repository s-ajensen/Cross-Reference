package crossReference;

public class BinTree {

    public BinTree() {

    }

    Node root = null;

    // Checks if the tree is empty
    public boolean isEmpty() {
        if(this.root == null) {
            return(true);
        } else {
            return(false);
        }
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return(this.root);
    }

    // returns true if str1 comes before str2 alphabetically
    public boolean isAlphabetic(String str1, String str2) {
        if(str1.compareTo(str2) < 0) {
            return(true);
        } else {
            return(false);
        }
    }

    public boolean existsNonRoot(Node current, Node node) {
        if(current != null) {
            if (current.getElement().equals(node.getElement())) {
                return (true);
                // Call recursively using right subtree until it is either found or found to not exist
            } else if (this.isAlphabetic(current.getElement(), node.getElement())) {
                return (existsNonRoot(current.getRight(), node));
            } else if (this.isAlphabetic(node.getElement(), current.getElement())) {
                return (existsNonRoot(current.getLeft(), node));
            } else {
                return (false);
            }
        } else {
            return(false);
        }
    }

    public boolean exists(Node node) {
        return(this.existsNonRoot(this.root, node));
    }

    public Node insertNonRoot(Node current, Node node) {
            if (current == null) {
                return (node);
            }

            // Check if root is alphabetically before inserted node
            if (this.isAlphabetic(current.getElement(), node.getElement())) {
                current.right = insertNonRoot(current.right, node);
                // If not, check if inserted node is alphabetically before the root
            } else if (this.isAlphabetic(node.getElement(), current.getElement())) {
                current.left = insertNonRoot(current.left, node);
            } else {
                return (current);
            }

            return (current);
    }

    public void insert(Node node) {
        this.root = insertNonRoot(this.root, node);
    }

    public Node findNodeNonRoot(Node current, String element) {
        Node node = new Node(element);
        if(exists(node)) {
            if(current.getElement().equals(element)) {
                return(current);
            } else if(this.isAlphabetic(current.getElement(), node.getElement())) {
                return(findNodeNonRoot(current.right, element));
            } else if(this.isAlphabetic(node.getElement(), current.getElement())) {
                return(findNodeNonRoot(current.getLeft(), element));
            } else {
                return(null);
            }
        } else {
            return(null);
        }
    }

    public Node find(String element) {
        return(findNodeNonRoot(this.root, element));
    }

    public void printTreeNonRoot(Node current) {
        if(current == null){
            return;
        }

        printTreeNonRoot(current.getLeft());
        System.out.print(String.format("%-10s" ,current.getElement()));
        for(int occurrence:current.occurrences) {
            System.out.print(String.format("%3s",  occurrence));
        }
        System.out.print("\n");

        printTreeNonRoot(current.getRight());

    }

    public void printTree() {
        printTreeNonRoot(this.root);
    }
}
