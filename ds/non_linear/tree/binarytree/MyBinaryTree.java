package ds.non_linear.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree {

    private TreeNode rootNode;
    private int count = 100;

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

    /**
     * 서브 바이나리 트리 생성
     * @param left 왼쪽 자식 노드
     * @param data 데이터
     * @param right 오른쪽 자식 노드
     * @return
     */
    public TreeNode makeSubBinaryTree(TreeNode left, Object data, TreeNode right) {
        TreeNode root = new TreeNode(data);
        root.leftNode = left;
        root.rightNode = right;

        return root;
    }

    /**
     * 전위 순회(Preorder Traversal)
     * 현재 노드 -> 왼쪽 노드 -> 오른쪽 노드 순으로 순회
     * @param rootNode
     * @return
     */
    public List<Object> preOrderTraversal(TreeNode rootNode) {
        List<Object> dataGroup = new ArrayList<>(count);
        if(rootNode != null) {
            dataGroup.add(rootNode.data);
            preOrderTraversal(rootNode.leftNode, dataGroup);
            preOrderTraversal(rootNode.rightNode, dataGroup);
        }

        return dataGroup;
    }

    private void preOrderTraversal(TreeNode rootNode, List<Object> dataGroup) {
        if(rootNode != null) {
            dataGroup.add(rootNode.data);
            preOrderTraversal(rootNode.leftNode, dataGroup);
            preOrderTraversal(rootNode.rightNode, dataGroup);
        }
    }

    public void inOrder() {}

    public void postOrder() {}




}
