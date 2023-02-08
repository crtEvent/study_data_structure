# Binary Tree

## 목차
* [Tree](#tree)
  + [Tree의 특징](#tree의-특징)
  + [Tree 구조](#tree-구조)
* [Binary Tree](#binary-tree)
  + [Binary Tree 특징](#binary-tree-특징)
  + [Binary Tree 종류](#binary-tree-종류)
* [Binary Tree 구현 방법](#binary-tree-구현-방법)
  + [1. 순차 자료구조(배열)을 이용한 방법](#순차-자료구조배열을-이용한-방법)
  + [2. 연결 자료구조를 이용한 방법](#연결-자료구조를-이용한-방법)
* [Binary Tree 순회 방법](#binary-tree-순회-방법)
  + [전위 순회(Preorder Traversal)](#전위-순회preorder-traversal)
  + [중위 순회(Inorder Traversal)](#중위-순회inorder-traversal)
  + [후위 순회(Postorder Traversal)](#후위-순회postorder-traversal)
- [구현](#구현)
---

## Tree
- 자료들 간에 계층관계를 가진 자료구조

### Tree의 특징
- 트리는 1개의 루트 노드를 가진다
- 루트 노드를 제외한 모든 노드는 단 1개의 부모 노드를 가진다
- 모든 노드는 0개 이상의 자식 노드를 가질 수 있다
- 순환 구조를 가지고 있지 않다
- 트리의 부분 트리도 트리의 모든 특징을 따른다

### Tree 구조
<img width="80%" src="https://user-images.githubusercontent.com/86359180/214319609-1a09091f-1548-4e0a-93a1-00c9e5ccd0e3.png"/><br>
- 노드(Node): 트리를 구성하는 요소(데이터의 index, value를 표현)
- 간선(Edge):  노드의 연결을 나타낸 선
- 루트 노드(Root Node): 트리의 시작 노드
- 부모 노드(Parent Node): 두 노드 관계에서 상위 노드
- 자식 노드(Child Node): 두 노드 관계에서 하위 노드
- 리프 노드(Leaf Node): 트리의 가장 하위에 있는 노드(자식 노드가 없는 노드, 차수가 0인 노드)
- 형제 노드(Sibling Node): 같은 부모 노드를 갖는 노드
- 서브 트리(Sub Tree): 전테 트리에 속해있는 작은 트리
- 노드의 차수(degree): 자식 노드의 수(A의 차수 = 3, C의 차수 = 1)
- 트리의 차수(degree of tree): 트리의 최대 차수(= 트리에서 가장 큰 차수를 가진 노드의 차수)

## Binary Tree
- 각 노드의 자식 노드가 2개 이하로 구성되어 있는 트리(= 트리의 최대 차수가 2인 트리)

### Binary Tree 특징
- n개의 노드를 가진 이진 트리는 항상 $(n-1)$개의 간선을 가진다
  - 루트 노드 이외의 모든 노드는 하나의 부모를 가지므로 $(n-1)$개의 간선을 가짐
- 높이가 h인 이진 트리가 가질 수 있는 `노드의 최소 개수`는 $(h+1)$개
  - 높이가 h이면 한 레벨에 최소한 한 개의 노드가 있어야 하므로, 최소 노드 개수 = $(h+1)$개
- 높이가 h인 이진 트리가 가질 수 있는 `노드의 최대 개수`는 $(2^{h+1}-1)$개
  - 하나의 노드는 최대 두개의 노드를 가질 수 있으므로 Level i에서 노드의 최대 개수 = &2^i&
  - 높이가 h인 포화 이진 트리의 노드 개수는 $\sum\limits_{i=0}^{h} {2^i} = 2^{h+1}-1$

### Binary Tree 종류
<img width="80%" src="https://user-images.githubusercontent.com/86359180/214319622-e215f088-de37-4895-b839-3da6e280557a.png"/><br>
- 포화 이진 트리(Full Binary Tree)
  - 모든 Level에 노드가 다 차있는 상태
  - 높이가 h일 때 최대 노드 수 $(2^{h+1}-1)$를 가지는 상태
  - 왼쪽에서 오른쪽으로 차례대로 번호를 붙인다
- 완전 이진 트리(Complete Binary Tree)
  - 1번 부터 n번 까지의 노드 위치가 포화 이진 트리와 모두 일치하는 상태
- 편향 이진 트리(Skewed Binary Tree)
  - 최소 개수의 노드 $(h+1)$를 가지고 있는 상태(왼쪽, 오른쪽 중 한 쪽으로만 서브트리를 가지고 있다)

## Binary Tree 구현 방법
<img width="80%" src="https://user-images.githubusercontent.com/86359180/214319628-bea4bbcc-6be6-4bad-8cd0-050994762b49.png"/><br>

### 1. 순차 자료구조(배열)을 이용한 방법
- 노드 번호를 배열의 index로 사용함
- 편의상 배열의 0번은 비워두고, 1번 칸에 루트 노드를 저장한다
- 배열이라 index를 찾기 쉽다

|  찾고 싶은 노드  |    index    |      성립 조건       |
|:----------:|:-----------:|:----------------:|
|   루트 노드    |      1      |      n > 0       |
|  i의 부모 노드  |  ⌊ i / 2 ⌋  |      i > 1       |
|  i의 왼쪽 자식  |    2 * i    |   (2 * i) <= n   |
| i의 오른쪽 자식  | (2 * i) + 1 | (2 * i) + 1 <= n |

※ ⌊ ⌋ : 반내림 기호<br>

### 2. 연결 자료구조를 이용한 방법
- 배열을 이용한 방법은 Tree에 빈 공간이 많으면 메모리 공간 낭비가 생긴다
  - 노드의 삽입/삭제 연산 시 많은 노드들을 한번에 이동/제거 해야 한다
- 위의 문제 때문에 연결 자료구조를 사용한다

## Binary Tree 순회 방법
- 순회(traversal): 트리에 있는 모든 노드를 한번씩 방문하는 것
  - 트리는 계층형 자료구조라 여러 순회 방법이 존재한다
```text
 [Tree Structure]
       (A)
      /   \
   (B)     (C)
   /  \    /  \
  (D) (E) (F) (G)
  
[Preorder Traversal - DLR]
A > B > D > E > C > F > G 
 
[Inorder Traversal - LDR]
D > B > E > A > F > C > G

[Postorder Traversal - LRD]
D > E > B > F > G > C > A
```
### 전위 순회(Preorder Traversal)
- `현재 노드(D)` -> `왼쪽 노드(L)` -> `오른쪽 노드(R)` 순으로 순회

### 중위 순회(Inorder Traversal)
- `왼쪽 노드(L)` -> `현재 노드(D)` -> `오른쪽 노드(R)` 순으로 순회

### 후위 순회(Postorder Traversal)
- `왼쪽 노드(L)` -> `오른쪽 노드(R)` -> `현재 노드(D)` 순으로 순회
---

# 구현
## ✳️ TreeNode 구조
```java
public class TreeNode {
    Object data;
    TreeNode leftNode;
    TreeNode rightNode;
}
```

## ✳️ TreeNode 데이터, Tree 구조 생성
```java
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
```
```java
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
}
```

## ✳️ 전위 순회(Preorder Traversal)
```java
    /**
     * 전위 순회(Preorder Traversal)
     * 현재 노드 -> 왼쪽 노드 -> 오른쪽 노드 순으로 순회
     * @param rootNode 순회를 시작할 노드
     * @return 순회한 순서대로 리스트에 담아 반환
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
```
```java
    @Test
    public void testPreOrder() {
        List<Object> dataGroup = tree.preOrderTraversal(root);

        dataGroup.stream()
                .filter(Objects::nonNull)
                .map(obj -> String.valueOf(obj))
                .forEach(System.out::println);
    }
```

## ️✳️ 중위 순회(Inorder Traversal)
```java
    /**
     * 중위 순회(Inorder Traversal)
     * 왼쪽 노드 -> 현재 노드 -> 오른쪽 노드 순으로 순회
     * @param rootNode 순회를 시작할 노드
     * @return 순회한 순서대로 리스트에 담아 반환
     */
    public List<Object> inOrderTraversal(TreeNode rootNode) {
        List<Object> dataGroup = new ArrayList<>(count);
        if(rootNode != null) {
            inOrderTraversal(rootNode.leftNode, dataGroup);
            dataGroup.add(rootNode.data);
            inOrderTraversal(rootNode.rightNode, dataGroup);
        }

        return dataGroup;
    }

    private void inOrderTraversal(TreeNode rootNode, List<Object> dataGroup) {
        if(rootNode != null) {
            inOrderTraversal(rootNode.leftNode, dataGroup);
            dataGroup.add(rootNode.data);
            inOrderTraversal(rootNode.rightNode, dataGroup);
        }
    }
```
```java
    @Test
    public void testInOrder() {
        List<Object> dataGroup = tree.inOrderTraversal(root);

        dataGroup.stream()
                .filter(Objects::nonNull)
                .map(obj -> String.valueOf(obj))
                .forEach(System.out::println);
    }
```

## ✳️ 후위 순회(Postorder Traversal)
```java
    /**
     * 후위 순회(Postorder Traversal)
     * 왼쪽 노드 -> 오른쪽 노드 -> 현재 노드 순으로 순회
     * @param rootNode 순회를 시작할 노드
     * @return 순회한 순서대로 리스트에 담아 반환
     */
    public List<Object> postOrderTraversal(TreeNode rootNode) {
        List<Object> dataGroup = new ArrayList<>(count);
        if(rootNode != null) {
            postOrderTraversal(rootNode.leftNode, dataGroup);
            postOrderTraversal(rootNode.rightNode, dataGroup);
            dataGroup.add(rootNode.data);
        }

        return dataGroup;
    }

    private void postOrderTraversal(TreeNode rootNode, List<Object> dataGroup) {
        if(rootNode != null) {
            postOrderTraversal(rootNode.leftNode, dataGroup);
            postOrderTraversal(rootNode.rightNode, dataGroup);
            dataGroup.add(rootNode.data);
        }
    }
```
```java
    @Test
    public void testPostOrder() {
        List<Object> dataGroup = tree.postOrderTraversal(root);

        dataGroup.stream()
                .filter(Objects::nonNull)
                .map(obj -> String.valueOf(obj))
                .forEach(System.out::println);
    }
```