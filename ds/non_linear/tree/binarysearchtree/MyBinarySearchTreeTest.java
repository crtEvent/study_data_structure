package ds.non_linear.tree.binarysearchtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyBinarySearchTreeTest {

    MyBinarySearchTree bst = new MyBinarySearchTree();

    @BeforeEach
    public void init() {
        bst.insert(7, "G");
        bst.insert(9, "I");
        bst.insert(8, "H");
        bst.insert(4, "D");
        bst.insert(2, "B");
        bst.insert(13, "M");
        bst.insert(14, "N");
        bst.insert(1, "A");
        bst.insert(10, "J");
        bst.insert(5, "E");
        bst.insert(17, "Q");
    }

    @Test
    public void testInsert() {
        bst.printInOrder();
    }

    @Test
    public void testSearch() {
        MyBinarySearchTree.BST_Node search;
        search = bst.search(10);
        System.out.println(search.key + " : " + search.data);
    }


}
