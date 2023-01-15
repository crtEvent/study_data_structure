# study_data_structure
자료 구조 구현해보기
## 목차
- [ArrayList](#ArrayList)
- [LinkedList](#LinkedList)

### 자료구조
- 데이터를 효율적으로 다룰 수 있게 도와주는 데이터 보관 방법과 데이터에 관한 연산
```text
Data Structures (자료 구조)
    - Simple Structure (단순 구조)
        - Integer (정수)
        - Real Number (실수)
        - String (문자열)
    - Linear Data Structures (선형 자료 구조)
        - Array List (순차 리스트)
        - Linked List (연결 리스트)
            - Singly Linked List (단순 연결 리스트)
            - Doubly Linked List (이중 연결 리스트)
            - Circular Linked List (원형 연결 리스트)
        - Stack (스택)
        - Queue (큐)
        - Deck (데크)
    - Non-Linear Data Structures (비선형 자료 구조)
        - Tree (트리)
            - Tree (일반트리)
            - Binary Tree (이진트리)
        - Graph (그래프)
            - Directed Graph (방향 그해프)
            - Undirected Graph (무방향 그래프)
    - File Structures (파일 구조)
        - Sequential File (순차 파일)
        - Index File (색인 파일)
        - Direct File (직접 파일)
```

### Big-O 표기법
<details>
<summary> Big-O 표기법 설명 </summary>

- 알고리즘의 실행 시간(시간 복잡도)을 표기할때 가장 널리 쓰이는 표기법
- 최악의 경우 몇 단계가 필요한지를 표기하는 방법(=상한선 기준)

#### 대표적인 것들
|     Big-O      |                                설명                                |
|:--------------:|:----------------------------------------------------------------:|
|      O(1)      | 데이터 수에 상관없이 연산횟수가 고정<br/>ex) 배열 읽기, 배열 끝에서 삽입/삭제, 스택 - push, pop |
|    O(logn)     |       데이터 수의 증가율에 비해서 연산횟수의 증가율이 훨씬 낮은 알고리즘<br/> ex) 이진 탐색       |
|      O(n)      |                 데이터의 수와 연산횟수가 비례<br/>ex) for문, 배열에서 특정 원소 검색                  |
|    O(nlogn)    |        데이터의 수가 두배로 늘때, 연산횟수는 두배를 조금 넘게 증가, ex)퀵, 병합, 힙 정렬        |
| O(n^2), O(n^3) |               제곱, 세제곱에 해당하는 연산횟수, ex) 이중, 삼중 for문                |
|     O(2^n)     |                 지수적증가라는 매우 안좋은 연산횟수, ex) 피보나치 수열                 |


#### 기타 표기법
- Big-Ω(빅 오메가): 최선의 경우를 표기
- Big-θ(빅 세타): 평균적인 상황의 경우를 표기

[Dico\'s_footPrint.log - [CS] 자료구조: Big-O 표기법 & 링크드 리스트(Linked List)](https://velog.io/@grinding_hannah/CS-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Big-O-%ED%91%9C%EA%B8%B0%EB%B2%95-%EB%A7%81%ED%81%AC%EB%93%9C-%EB%A6%AC%EC%8A%A4%ED%8A%B8Linked-List)
<br>[kimkrh.log - 빅-오 표기법(Big-O Notation)](https://velog.io/@kimkrh/%EB%B9%85-%EC%98%A4-%ED%91%9C%EA%B8%B0%EB%B2%95Big-O-Notation)
</details>

# ArrayList
<details>
<summary> ArrayList 설명 </summary>

- Object 배열을 이용해서 데이터를 순차적으로 저장
- 배열에 공간이 부족하면 더 큰 배열을 새로 생성해서 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음에 객체를 추가한다
- 장점) 데이터를 읽어오고 순차적으로 저장하는 데에 효율이 좋다
- 단점) 데이터가 많을 수록 배열 중간에 데이터를 추가, 삭제할 때 작업시간 ↑

### :question: 크기(size)와 용량(capacity)
- 크기(size): 배열이 포함하고 있는 요소의 개수
- 용량(capacity): 배열의 전체 크기

## ArrayList 데이터 추가

## ArrayList 데이터 삭제

</details>

<details>
<summary> ArrayList 코드 </summary>

| 메서드                              | 설명                                 |
|----------------------------------|------------------------------------|
|int size()| ArrayList에 저장된 객체의 개수 반환           |
|boolean isEmpty()| ArrayList가 비어있는지 확인                |
|int indexOf(Object element)| 지정된 객체가 저장된 위치를 찾아 반환              |
|int lastIndexOf(Object element)| 객체가 저장된 위치를 끝부터 역방향으로 검색해서 반환      |
|boolean contains(Object element)| 지정된 객체가 ArrayList에 있는지 확인          |
|boolean add(Object element)| ArrayList 마지막에 객체 저장. 성공하면 true 반환 |
|boolean add(int index, Object element)| 지정된 위치(index)에 객체 저장               |
|Object get(int index)| 지정된 위치(index)에 저장된 객체 반환           |
|Object remove(int index)| 지정된 위치(index)에 있는 객체를 제거. 제거된 객체를 반환         |
|boolean remove(Object element)| 지정한 객체를 제거. 성공하면 true 반환           |
|void trimSize()|용량을 크기에 맞게 줄인다 (빈 공간을 없앤다)|
|void ensureCapacity(int minCapacity)|ArrayList의 용량이 최소한(minCapacity)가 되도록 한다|

## :sparkle: boolean add(Object element): ArrayList 마지막에 객체 저장. 성공하면 true 반환
```java
    /**
     * ArrayList 마지막에 객체 저장. 성공하면 true 반환
     * @param element 저장할 객체
     * @return 객체 저장 성공 여부
     */
    public boolean add(Object element) {
        elementData[listSize] = element;
        listSize++;

        return true;
    }
```
- 현재 배열에 10개의 요소가 들어 있다면
  - listSize: 10, 배열의 마지막 index: 9
  - index 10에 새로운 요소를 저장하고 listSize++ 해준다

</details>

# LinkedList
<details>
<summary> LinkedList 설명 </summary>

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

## Big-O
|연산|        Big-O        |
|:---:|:-------------------:|
|읽기|        O(n)         |
|검색|        O(n)         |
|삽입|O(n), 맨 앞에서부터 하면 O(1)|
|삭제|O(n), 맨 앞에서부터 하면 O(1)|
</details>

<details>
<summary> LinkedList 코드 </summary>

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