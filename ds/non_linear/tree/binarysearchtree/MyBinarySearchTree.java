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

    private BST_Node insert(BST_Node root, int key, Object data) {
        BST_Node newNode = new BST_Node(key, data);

        if(root == null) {
            return newNode;
        } else if(newNode.key < root.key) {
            root.leftNode = insert(root.leftNode, key, data);
            return root;
        } else if(newNode.key > root.key) {
            root.rightNode = insert(root.rightNode, key, data);
            return root;
        }

        return root;
    }

    public void insert(int key, Object data) {
        root = insert(root, key, data);
    }
}
