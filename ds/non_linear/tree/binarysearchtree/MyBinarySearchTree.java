package ds.non_linear.tree.binarysearchtree;

public class MyBinarySearchTree {

    private BST_Node rootNode;

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

    public BST_Node search(int key) {
        BST_Node tempNode = rootNode;
        while (tempNode != null) {
            if(key < tempNode.key) {
                tempNode = tempNode.leftNode;
            } else if(key > tempNode.key) {
                tempNode = tempNode.rightNode;
            } else {
                return tempNode;
            }
        } // end - while()

        return null;
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
        } else {
            return root;
        }

    }

    public void insert(int key, Object data) {
        rootNode = insert(rootNode, key, data);
    }

    private void printInOrder(BST_Node root) {
        if(root != null) {
            printInOrder(root.leftNode);
            System.out.printf("[%d]-[%d:%s]-[%d]%n"
                    , (root.leftNode != null)? root.leftNode.key : 0
                    , root.key
                    , root.data
                    ,(root.rightNode != null)? root.rightNode.key : 0);
            printInOrder(root.rightNode);
        }
    }

    public void printInOrder() {
        printInOrder(rootNode);
    }
}
