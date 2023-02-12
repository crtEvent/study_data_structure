package ds.non_linear.tree.binarysearchtree;

import org.junit.jupiter.api.Test;

public class MyBinarySearchTreeTest {

    MyBinarySearchTree bst = new MyBinarySearchTree();

    @Test
    public void testInsert() {
        bst.insert(1, "A");
        bst.insert(10, "10");
        bst.insert(5, "E");
        bst.insert(2, "B");
        bst.insert(4, "D");
        bst.insert(3, "C");

        bst.printPreOrder();
    }
}
