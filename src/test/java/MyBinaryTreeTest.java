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
}