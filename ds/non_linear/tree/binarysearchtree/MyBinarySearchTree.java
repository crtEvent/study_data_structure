package ds.non_linear.tree.binarysearchtree;

public class MyBinarySearchTree {

    private BST_Node root;

    public class BST_Node {
        int key;
        Object data;
        BST_Node leftNode;
        BST_Node rightNode;

        public BST_Node(int key, Object data) {
            this(key, data, null, null);
        }

        public BST_Node(int key, Object data, BST_Node leftNode, BST_Node rightNode) {
            this.key = key;
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }


}
