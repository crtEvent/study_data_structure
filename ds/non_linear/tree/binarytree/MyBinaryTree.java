package ds.non_linear.tree.binarytree;

public class MyBinaryTree {

    private TreeNode rootNode;
    private int count = 0;

    public class TreeNode {
        Object data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(Object data) {
            this(data, null, null);
        }

        public TreeNode(Object data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    public TreeNode makeSubBinaryTree(TreeNode left, Object data, TreeNode right) {
        TreeNode root = new TreeNode(data);
        root.leftNode = left;
        root.rightNode = right;

        return root;
    }

    public void addLeft() {

    }

    public void addRight() {

    }

    public void preOrder() {}

    public void inOrder() {}

    public void postOrder() {}




}
