# study_data_structure
자료 구조 구현해보기
## 목차
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

# LinkedList
<details>
<summary> LinkedList 설명 </summary>

<img src="https://raw.githubusercontent.com/crtEvent/image_repo/main/data_structure_image/LinkedList.png?token=GHSAT0AAAAAAB45DRL3I6TP3WEZOSWYLYMKY52X62A" width="600" height="100"><br>
- 불연속적으로 존재하는 데이터를 서로 연결(link)한 형태
- LinkedList의 각 요소(node)들은 자신과 연결된 다음 요소에 대한 참조(주소값)와 데이터로 구성
- 장점) 데이터 추가/삭제 과정에서 ArrayList처럼 배열을 복사하는 과정이 없어 처리속도가 빠르다
- 단점) 불연속적을 위치한 요소들이 서로 연결된 것이라 처음부터 n번째 데이터 까지 차례대로 따라가야만 원하는 값을 얻을 수 있다
- [Java LinkedList 공식문서](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html)

## LinkedList 데이터 삭제
- 삭제하고자 하는 요소의 이전요소 -> 삭제하고자 하는 요소의 다음 요소를 참조
<br><img src="https://raw.githubusercontent.com/crtEvent/image_repo/main/data_structure_image/LinkedList%20delete.png?token=GHSAT0AAAAAAB45DRL3MBNLYD7EJKAWJMJUY52X7HA" width="500" height="300"><br>

## LinkedList 데이터 추가
- 새로운 요소를 생성
- 추가하고자 하는 위치 이전 요소의 참조 -> 새로운 요소에 대한 참조로 변경
- 새로운 요소가 그 다음 요소를 참조하도록 변경
- -> ArrayList처럼 배열을 복사하는 과정이 없어 처리속도가 빠르다
<br><img src="https://raw.githubusercontent.com/crtEvent/image_repo/main/data_structure_image/LinkedList%20insert.png?token=GHSAT0AAAAAAB45DRL2VAUWL3DJOUP243L4Y52X4AA" width="500" height="260"><br>

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

</details>