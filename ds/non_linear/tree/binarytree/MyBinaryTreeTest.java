package ds.non_linear.tree.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class MyBinaryTreeTest {

    MyBinaryTree tree;
    MyBinaryTree.TreeNode root;

    @BeforeEach
    public void makeBinaryTree() {
        /* [Tree Structure]
         *      (A)
         *     /   \
         *  (B)     (C)
         *  /  \    /  \
         * (D) (E) (F) (G)
         */
        tree = new MyBinaryTree();
        MyBinaryTree.TreeNode n7 = tree.makeSubBinaryTree(null, "G", null);
        MyBinaryTree.TreeNode n6 = tree.makeSubBinaryTree(null, "F", null);
        MyBinaryTree.TreeNode n5 = tree.makeSubBinaryTree(null, "E", null);
        MyBinaryTree.TreeNode n4 = tree.makeSubBinaryTree(null, "D", null);
        MyBinaryTree.TreeNode n3 = tree.makeSubBinaryTree(n6, "C", n7);
        MyBinaryTree.TreeNode n2 = tree.makeSubBinaryTree(n4, "B", n5);
        root = tree.makeSubBinaryTree(n2, "A", n3);
    }

    @Test
    public void testPreOrder() {
        List<Object> dataGroup = tree.preOrderTraversal(root);

        dataGroup.stream()
                .filter(Objects::nonNull)
                .map(obj -> String.valueOf(obj))
                .forEach(System.out::println);
    }

    @Test
    public void testInOrder() {
        List<Object> dataGroup = tree.inOrderTraversal(root);

        dataGroup.stream()
                .filter(Objects::nonNull)
                .map(obj -> String.valueOf(obj))
                .forEach(System.out::println);
    }

    @Test
    public void testPostOrder() {
        List<Object> dataGroup = tree.postOrderTraversal(root);

        dataGroup.stream()
                .filter(Objects::nonNull)
                .map(obj -> String.valueOf(obj))
                .forEach(System.out::println);
    }
}
