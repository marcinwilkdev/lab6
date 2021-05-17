import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBinaryTreeTest {

    MyBinaryTree<Integer> myBinaryTree;

    @BeforeEach
    void setUp() {
        myBinaryTree = new MyBinaryTree<>();
    }

    @Test
    void insertFirst() {
        myBinaryTree.insert(1);
        myBinaryTree.insert(2);

        assertNotNull(myBinaryTree.getRoot());
        assertEquals(1, myBinaryTree.getRoot().getValue());
    }

    @Test
    void insertAnother() {
        myBinaryTree.insert(1);
        myBinaryTree.insert(2);

        myBinaryTree.insert(50);
        myBinaryTree.insert(48);

        assertNotNull(myBinaryTree.getRoot().getRight());
        assertEquals(2, myBinaryTree.getRoot().getRight().getValue());

        assertEquals(48, myBinaryTree.getRoot().getRight().getRight().getLeft().getValue());
    }

    @Test
    void search() {
        myBinaryTree.insert(5);
        myBinaryTree.insert(4);
        myBinaryTree.insert(8);
        myBinaryTree.insert(6);
        myBinaryTree.insert(7);

        assertTrue(myBinaryTree.search(8));
        assertTrue(myBinaryTree.search(7));

        assertFalse(myBinaryTree.search(1));
        assertFalse(myBinaryTree.search(11));
    }

    @Test
    void delete() {
        myBinaryTree.insert(0);
        myBinaryTree.insert(8);
        myBinaryTree.insert(10);
        myBinaryTree.insert(9);
        myBinaryTree.insert(11);
        myBinaryTree.insert(12);
        myBinaryTree.insert(-5);
        myBinaryTree.insert(-3);
        myBinaryTree.insert(-4);
        myBinaryTree.insert(-10);
        myBinaryTree.insert(-8);

        myBinaryTree.delete(-5);
        myBinaryTree.delete(10);

        assertFalse(myBinaryTree.search(-5));
        assertTrue(myBinaryTree.search(-4));

        assertFalse(myBinaryTree.search(10));
        assertTrue(myBinaryTree.search(9));
    }
}