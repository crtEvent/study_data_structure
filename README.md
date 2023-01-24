# study_data_structure
자료 구조 구현해보기 with JAVA 11

## 목차
- Linear Data Structures (선형 자료 구조)
  - [Array List (순차 리스트)](ds/linear/arraylist)
  - [Linked List (연결 리스트)](ds/linear/linkedlist)

## 자료구조
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

## Big-O 표기법
- 알고리즘의 실행 시간(시간 복잡도)을 표기할때 가장 널리 쓰이는 표기법
- 최악의 경우 몇 단계가 필요한지를 표기하는 방법(=상한선 기준)

### 대표적인 것들
|     Big-O      |                                설명                                |
|:--------------:|:----------------------------------------------------------------:|
|      O(1)      | 데이터 수에 상관없이 연산횟수가 고정<br/>ex) 배열 읽기, 배열 끝에서 삽입/삭제, 스택 - push, pop |
|    O(logn)     |       데이터 수의 증가율에 비해서 연산횟수의 증가율이 훨씬 낮은 알고리즘<br/> ex) 이진 탐색       |
|      O(n)      |                 데이터의 수와 연산횟수가 비례<br/>ex) for문, 배열에서 특정 원소 검색                  |
|    O(nlogn)    |        데이터의 수가 두배로 늘때, 연산횟수는 두배를 조금 넘게 증가, ex)퀵, 병합, 힙 정렬        |
| O(n^2), O(n^3) |               제곱, 세제곱에 해당하는 연산횟수, ex) 이중, 삼중 for문                |
|     O(2^n)     |                 지수적증가라는 매우 안좋은 연산횟수, ex) 피보나치 수열                 |


### 기타 표기법
- Big-Ω(빅 오메가): 최선의 경우를 표기
- Big-θ(빅 세타): 평균적인 상황의 경우를 표기

[Dico\'s_footPrint.log - [CS] 자료구조: Big-O 표기법 & 링크드 리스트(Linked List)](https://velog.io/@grinding_hannah/CS-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-Big-O-%ED%91%9C%EA%B8%B0%EB%B2%95-%EB%A7%81%ED%81%AC%EB%93%9C-%EB%A6%AC%EC%8A%A4%ED%8A%B8Linked-List)
<br>[kimkrh.log - 빅-오 표기법(Big-O Notation)](https://velog.io/@kimkrh/%EB%B9%85-%EC%98%A4-%ED%91%9C%EA%B8%B0%EB%B2%95Big-O-Notation)
