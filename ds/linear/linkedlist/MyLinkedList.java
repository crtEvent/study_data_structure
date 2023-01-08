package ds.linear.linkedlist;

public class MyLinkedList {
    private Node head;
    private int listSize = 0;

    private class Node {
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * List에서 지정된 위치에 있는 요소를 반환
     * @param index 반환할 요소의 위치
     * @return 지정된 위치에 있는 요소
     */
    public Object get(int index) {
        return null;
    }

    /**
     * 지정된 객체가 저장된 첫 번째 위치를 반환
     * @param data 검색할 요소
     * @return 지정된 객체가 저장된 첫 번째 위치
     *         List에 지정된 객체가 없으면 -1 반환
     */
    public int indexOf(Object data) {
        return 0;
    }

    /**
     * List가 비어있는지 확인
     * @return List가 비어있으면 true
     */
    public boolean isEmpty() {

        return false;
    }

    /**
     * List에 저장된 객체의 개수 반환
     * @return List에 저장된 객체의 개수
     */
    public int size() {
        return 0;
    }

    /**
     * List의 시작 부분에 지정된 요소 추가.
     * @param data 추가할 요소
     */
    public void addFirst(Object data) {

    }

    /**
     * List의 끝 부분에 지정된 요소 추가
     * @param data 추가할 요소
     */
    public void addLast(Object data) {
        Node newNode = new Node(data);

        if(head == null) { // head가 null인 경우 head가 새 노드를 참조
            this.head = newNode;
        } else {
            // 마지막 node를 찾는다
            Node tempNode = head;
            while(tempNode.next != null) {
                tempNode = tempNode.next;  // 다음 노드를 참조
            }
            tempNode.next = newNode; // 마지막 노드의 next에 삽입
        }
        listSize++;
    }

    /**
     * List의 지정된 위치에 지정된 요소 추가
     * @param index 추가할 요소의 위치
     * @param data 추가할 요소
     */
    public void add(int index, Object data) {

    }

    /**
     * List의 첫 번째 요소 제거
     * @return 제거된 list의 첫 번째 요소
     */
    public Object removeFirst() {
        return null;
    }

    /**
     * List의 마지막 요소 제거
     * @return 제거된 list의 마지막 요소
     */
    public Object removeLast() {
        return null;
    }

    /**
     * List에서 지정된 위치에 있는 요소 제거
     * @param index 제거할 요소의 위치
     * @return 제거된 요소
     */
    public Object remove(int index) {
        return null;
    }

    /**
     * 지정된 요소가 List에 있는 경우 List에서 첫 번째 지정된 요소 제거
     * @param data 제거할 요소
     * @return 지정된 요소가 List에 있는 경우 true
     */
    public boolean remove(Object data) {
        return false;
    }

    /**
     * list의 모든 요소들을 문자열로 반환
     * 각 요소는 대괄호([])안에 표시된다
     * 각 요소는 String.valueOf(Object)에 의해 문자열로 변환된다
     * @return list의 모든 요소들을 표현한 문자열
     */
    public String toString() {
        if(head == null){
            return "[]";
        }

        Node tempNode = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while(tempNode.next != null) {
            sb.append(tempNode.data + ", ");
            tempNode = tempNode.next;
        }
        sb.append(tempNode.data);
        sb.append("]");

        return sb.toString();
    }

}
