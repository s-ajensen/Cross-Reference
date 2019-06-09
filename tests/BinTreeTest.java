package tests;

import org.junit.jupiter.api.Test;
import crossReference.*;

import static org.junit.jupiter.api.Assertions.*;

class BinTreeTest {

    public void printNode(Node node) {
        if(node != null) {
            System.out.println(node.getElement());
        } else {
            System.out.println("null");
        }
        if(node.getLeft() != null) {
            System.out.println("    L:" + node.getLeft().getElement());
        } else {
            System.out.println("    L:null");
        }
        if(node.getRight() != null) {
            System.out.println("    R:" + node.getRight().getElement());
        } else {
            System.out.println("    R:null");
        }
    }

    @Test
    public void assertEmpty() {
        BinTree bintree = new BinTree();

        assertTrue(bintree.isEmpty());
    }
    @Test
    public void assertHasValue() {
        BinTree binTree = new BinTree();

        binTree.setRoot(new Node("test"));
        assertFalse(binTree.isEmpty());
    }

    @Test
    public void assertRootIsSet() {
        BinTree binTree = new BinTree();

        Node node = new Node("test");

        binTree.setRoot(node);
        assertEquals(node,binTree.getRoot());
    }

    @Test
    public void insertRootTest() {
        BinTree bintree = new BinTree();

        Node node = new Node("test");

        bintree.insert(node);

        assertEquals(node, bintree.getRoot());
    }

    @Test
    public void isAlphabeticTest() {
        BinTree binTree = new BinTree();

        assertFalse(binTree.isAlphabetic("test", "test"));
        assertTrue(binTree.isAlphabetic("test", "test2"));
        assertTrue(binTree.isAlphabetic("a", "b"));
        assertTrue(binTree.isAlphabetic("a", "beeeee"));
        assertTrue(binTree.isAlphabetic("aaaaaa", "b"));
        assertFalse(binTree.isAlphabetic("test2", "test1"));
        assertFalse(binTree.isAlphabetic("bbbb", "a"));
        assertFalse(binTree.isAlphabetic("b", "a"));
        assertFalse(binTree.isAlphabetic("b", "aaaaa"));
    }

    @Test
    public void insertNodeNonEmptyTest() {
        BinTree binTree = new BinTree();

        Node node = new Node("test");
        Node node2 = new Node("test2");
        Node node3 = new Node("best");
        Node node4 = new Node("test3");

        binTree.insert(node);
        binTree.insert(node2);
        binTree.insert(node3);
        binTree.insert(node4);

        //System.out.println(binTree.getRoot().getElement());

        assertEquals(node,binTree.getRoot());
        assertEquals(node2, binTree.getRoot().getRight());
        assertEquals(node3, binTree.getRoot().getLeft());
        this.printNode(node);
        this.printNode(node.getLeft());
        this.printNode(node.getRight());
        assertEquals(node4, binTree.getRoot().getRight().getRight());
        assertTrue(binTree.exists(new Node("test3")));
        binTree.printTree();
    }

    @Test
    public void existsEmptyTest() {
        BinTree bintree = new BinTree();

        Node node = new Node("");

        assertFalse(bintree.exists(node));
    }

    @Test
    public void existsOneElementTest() {
        BinTree bintree = new BinTree();

        Node node = new Node("test");
        bintree.insert(node);

        assertTrue(bintree.exists(node));
    }

    @Test
    public void findNonExistingTest() {
        BinTree binTree = new BinTree();

        assertNull(binTree.find("test"));
    }

    @Test
    public void findRootTest() {
        BinTree binTree = new BinTree();

        Node node = new Node("test");
        binTree.insert(node);

        assertEquals(node, binTree.find("test"));
    }

    @Test
    public void findChildTest() {
        BinTree binTree = new BinTree();

        Node node1 = new Node("test");
        Node node2 = new Node("test1");
        Node node3 = new Node("test2");

        binTree.insert(node1);
        binTree.insert(node2);
        binTree.insert(node3);

        assertEquals(node1, binTree.find("test"));
        assertEquals(node2, binTree.find("test1"));
        assertEquals(node3, binTree.find("test2"));
    }

    @Test
    public void insertTestAgain() {
        BinTree binTree = new BinTree();

        /*binTree.insert(new Node("set"));
        binTree.insert(new Node("an"));
        binTree.insert(new Node("integer"));
        binTree.insert(new Node("variable"));
        binTree.insert(new Node("x1"));
        binTree.insert(new Node("to"));
        binTree.insert(new Node("be"));
        binTree.insert(new Node("2"));
        binTree.insert(new Node("set"));*/

        Node node1 = new Node("set");
        Node node2 = new Node("an");
        Node node3 = new Node("integer");
        Node node4 = new Node("variable");
        Node node5 = new Node("x1");
        Node node6 = new Node("to");
        Node node7 = new Node("be");
        Node node8 = new Node("2");
        Node node9 = new Node("set");

        binTree.insert(node1);
        binTree.insert(node2);
        binTree.insert(node3);
        binTree.insert(node4);
        binTree.insert(node5);
        binTree.insert(node6);
        binTree.insert(node7);
        binTree.insert(node8);
        binTree.insert(node9);

        //System.out.println(binTree.getRoot().getLeft().getElement());

        binTree.printTree();
    }
}