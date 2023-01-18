# LinkedList

<img width="90%" src="https://user-images.githubusercontent.com/86359180/211203452-d13e5b25-e2d4-4f6c-9b15-4904eba38e36.png"><br>
- 불연속적으로 존재하는 데이터를 서로 연결(link)한 형태
- LinkedList의 각 요소(node)들은 자신과 연결된 다음 요소에 대한 참조(주소값)와 데이터로 구성
- 장점) 데이터 추가/삭제 과정에서 ArrayList처럼 배열을 복사하는 과정이 없어 처리속도가 빠르다
- 단점) 불연속적을 위치한 요소들이 서로 연결된 것이라 처음부터 n번째 데이터 까지 차례대로 따라가야만 원하는 값을 얻을 수 있다
- [Java LinkedList 공식문서](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)

## LinkedList 데이터 삭제
- 삭제하고자 하는 요소의 이전요소 -> 삭제하고자 하는 요소의 다음 요소를 참조
  <br><img width="80%" src="https://user-images.githubusercontent.com/86359180/211203446-3f430d81-fc29-47a6-a22d-441a292287c3.png"/><br>

## LinkedList 데이터 추가
- 새로운 요소를 생성
- 추가하고자 하는 위치 이전 요소의 참조 -> 새로운 요소에 대한 참조로 변경
- 새로운 요소가 그 다음 요소를 참조하도록 변경
- -> ArrayList처럼 배열을 복사하는 과정이 없어 처리속도가 빠르다
  <br><img width="80%" src="https://user-images.githubusercontent.com/86359180/211203450-43d382d4-3179-4127-a3bb-ca387465bade.png"/><br>

## LinkedList Big-O
|     연산      |         Big-O         |
|:-----------:|:---------------------:|
|     검색      |         O(n)          |
| 맨 앞에서 삽입/삭제 |         O(1)          |
|   중간에서 삽입/삭제   |         O(n)          |
|  맨 끝에서 삽입/삭제   |         O(n)          |
---

# 구현
## 클래스 & 메서드
| 메서드                              |설명|
|----------------------------------|---|
| Node get(int index)              |List에서 지정된 위치에 있는 Node를 반환|
| int indexOf(Object data)         |지정된 객체가 저장된 첫 번째 위치를 반환|
| boolean isEmpty()                |List가 비어있는지 확인|
| int size()                       |List에 저장된 객체의 개수 반환|
| addFirst(Object data)            |List의 시작 부분에 지정된 요소 추가|
| void addLast(Object data)        |List의 끝 부분에 지정된 요소 추가|
| void add(int index, Object data) |List의 지정된 위치에 지정된 요소 추가|
| Object removeFirst()             |List의 첫 번째 요소를 제거 후 반환|
|Object removeLast()|List의 마지막 요소를 제거 후 반환|
|Object remove(int index)|List에서 지정된 위치에 있는 요소를 제거 후 반환|
| boolean remove(Object data)|지정된 요소가 List에 있는 경우 List에서 첫 번째 지정된 요소 제거|
|toString()|list의 모든 요소들을 문자열로 반환|

# :large_orange_diamond: 1. MyLinkedList Class & Node Class
```java
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
    // ...생략
}
```
### 1. Node는 MyLinkedList Class 내에 내부 클래스(Inner Class)로 생성
- 내부 클래스로 생성한 이유
    - 두 클래스(Node와 MyLinkedList)가 서로 긴밀한 관계에 있음<br>
      -> 내부 클래스로 접근하기 쉽게 하기 위함
    - 외부에는 불필요한 클래스(Node)를 감출 수 있음<br>
      -> 코드 복잡성 ↓

## :sparkle: toString() : list의 모든 요소들을 문자열로 반환
- test를 위해 가정 먼저 구현
```java
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
```
**1. head가 비어있으면 "[]" 반환**
**2. while문으로 head부터 마지막 Node까지 순회**
- head부터 마지막 Node까지 순회하는  로직
 ```java
Node tempNode = head;

while(tempNode.next != null) {
    tempNode = tempNode.next;
}
```
- tempNode.next == null이면 마지막 Node이다
  **3. 순회하면서 요소를 StringBuilder에 추가**

## :sparkle: void addLast(Object data): List의 끝 부분에 지정된 요소 추가
```java
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
```
**1. 추가할 요소로 새로운 Node 생성**<br>
```java
Node newNode = new Node(data);
```
**2. head가 null인 경우(=list가 비어있다) head가 새 노드를 참조**<br>
```java
if(head == null) { // head가 null인 경우 head가 새 노드를 참조
    this.head = newNode;
}
```
**3. 그 외의 경우 마지막 Node를 찾아 next에 새로운 Node 삽입**<br>
```java
} else {
    // 마지막 node를 찾는다
    Node tempNode = head;
    while(tempNode.next != null) {
        tempNode = tempNode.next;  // 다음 노드를 참조
    }
    tempNode.next = newNode; // 마지막 노드의 next에 삽입
}
```
**4. list의 size를 늘려준다**<br>
```java
listSize++;
```

## :sparkle: void addFirst(): List의 시작 부분에 지정된 요소 추가.
```java
    /**
     * List의 시작 부분에 지정된 요소 추가.
     * @param data 추가할 요소
     */
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        listSize++;
    }
```
**1. 새로운 노드 생성**<br>
**2. 새로운 노드의 다음을 head로 지정 = 현재 헤드 노드가 두 번째 순서가 되는 과정**<br>
**3. 헤드를 새 노드로 지정 = 새 노드를 첫 번째 순서로 한다**<br>
**4. list의 size를 늘려준다**<br>

## :sparkle: void add(int index, Object data): List의 지정된 위치에 지정된 요소 추가
```java
    /**
     * List의 지정된 위치에 지정된 요소 추가
     * @param index 추가할 요소의 위치
     * @param data 추가할 요소
     */
    public void add(int index, Object data) {
        if(index <= 0) {
            addFirst(data);
            return;
        }

        if(index > listSize) {
            addLast(data);
            return;
        }

        Node previousTempNode = get(index-1);
        Node tempNode = get(index);
        Node newNode = new Node(data);

        newNode.next = tempNode;
        previousTempNode.next = newNode;
        listSize++;
    }
```
### [index 입력값 검증]
**1. index가 0보다 작으면 list의 첫 번째에 추가한다**<br>
```java
if(index <= 0) {
    addFirst(data);
    return;
}
```
**2. index가 listSize보다 크면 list의 맨 마지막에 추가한다**<br>
```java
if(index > listSize) {
    addLast(data);
    return;
}
```
<br>

### [새로운 노드를 원하는 위치에 추가하는 로직]
```java
Node previousTempNode = get(index-1);
Node tempNode = get(index);
Node newNode = new Node(data);

newNode.next = tempNode;
previousTempNode.next = newNode;
listSize++;
```
**1. 추가할 위치의 이전 Node를 불러온다**<br>
**2. 추가할 위치에 있는 Node를 불러온다**<br>
**3. 새로운 Node 생성(= 새로 추가할 Node)**<br>
**4. 새로운 Node의 next는 원해 추가할 위치의 Node**<br>
**5. 추가할 위치의 이전 Node.next는 새로운 Node**<br>
**6. list의 size를 늘려준다**<br>

## :sparkle: Object removeFirst(): List의 첫 번째 요소를 제거 후 반환
```java
    /**
     * List의 첫 번째 요소를 제거 후 반환
     * 제거할 요소가 없으면 null을 반환
     * @return 제거된 list의 첫 번째 요소
     */
    public Object removeFirst() {
        if(listSize == 0) {
            return null;
        }

        Node tempNode = head;
        Node nodeToBeFirst = head.next;

        head = nodeToBeFirst;
        listSize--;

        return tempNode.data;
    }
```
**1. 이미 list가 비어 있다면 null을 반환**<br>
**2. head를 tempNode에 저장**<br>
**3. head.next를 저장**<br>
&nbsp;&nbsp;&nbsp;&nbsp;- 첫 번째 Node가 제거 된다면 head.next가 첫 번째 Node가 될 것이다<br>
**4. head에 3번에서 저장했던 head.next를 저장**<br>
&nbsp;&nbsp;&nbsp;&nbsp;- head.next를 첫 번째 Node로 지정함
**5. list의 size를 늘려준다**<br>
**6. tempNode에 저장헀던 head(삭제될 Node)의 data를 반환**<br>
- :question:궁금증) tempNode값을 그대로 놔두면 메서드가 종료될 때 실제 저장공간에서 내려갈까? 그대로 남아 있을까?

## :sparkle: Object removeLast(): List의 마지막 요소를 제거 후 반환
```java
    /**
     * List의 마지막 요소를 제거 후 반환
     * 제거할 요소가 없으면 null을 반환
     * @return 제거된 list의 마지막 요소
     */
    public Object removeLast() {
        if(listSize == 0) {
            return null;
        }

        if(listSize == 1) {
            Node nodeToBeDeleted = get(0);
            head = null;
            listSize--;
            return nodeToBeDeleted.data;
        }

        Node tempNode = get(listSize-2);
        Node nodeToBeDeleted = tempNode.next;
        tempNode.next = null;
        listSize--;

        return nodeToBeDeleted.data;
    }
```
### [list의 크기가 0 또는 1일 경우]
```java
if(listSize == 0) {
    return null;
}

if(listSize == 1) {
    Node nodeToBeDeleted = get(0);
    head = null;
    listSize--;
    return nodeToBeDeleted.data;
}
```
**1. list의 크기가 0이면 null 반환**<br>
**2. list의 크기가 1이면 바로 첫 번째 Node의 data 반환**<br>
<br>

### [list의 마지막 요소 반환 로직]
```java
Node tempNode = get(listSize-2);
Node nodeToBeDeleted = tempNode.next;
tempNode.next = null;
listSize--;

return nodeToBeDeleted.data;
```
**1. tempNode에 뒤에서 두 번째 Node를 저장**<br>
**2. 삭제될 Node는 tempNode의 next(= 마지막 Node)**<br>
**3. tempNode의 next를 null로 바꾼다(= 마지막 Node를 버린다)**<br>
**4. listSize 감소**<br>
**5. 제거된 Node(=마지막 Node였던 것)의 data를 반환**<br>

## :sparkle: Object remove(int index): List에서 지정된 위치에 있는 요소를 제거 후 반환
```java
    /**
     * List에서 지정된 위치에 있는 요소를 제거 후 반환
     * 제거할 요소가 없으면 null을 반환
     * @param index 제거할 요소의 위치
     * @return 제거된 요소
     */
    public Object remove(int index) {
        if(index <= 0) {
            return removeFirst();
        }

        if(index >= listSize) {
            return removeLast();
        }

        Node tempNode = get(index-1);
        Node nodeToBeDeleted = tempNode.next;
        tempNode.next = tempNode.next.next;
        listSize--;

        return nodeToBeDeleted.data;
    }
```
### [index 입력값 검증]
```java
if(index <= 0) {
    return removeFirst();
}

if(index >= listSize) {
    return removeLast();
}
```
**1. index가 0보다 작거나 같으면 removeFirst()**<br>
**2. index가 list의 크기보다 크거나 같으면 removeLast()**<br>
<br>

### [원하는 위치의 요소를 제거하는 로직]
```java
Node tempNode = get(index-1);
Node nodeToBeDeleted = tempNode.next;
tempNode.next = tempNode.next.next;
listSize--;

return nodeToBeDeleted.data;
```
**1. tempNode에 저거할 요소 이전의 Node를 저장**<br>
**2. 삭제될 노드는 tempNode의 next**<br>
**3. tempNode의 next에 tempNode의 다다음 Node를 저장(= tempNode의 다음 Node를 버린다)**<br>
**4. listSize 감소**<br>
**5. 삭제된 Node의 data 반환**<br>

</details>