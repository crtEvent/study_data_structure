# ArrayList

- Object 배열을 이용해서 데이터를 순차적으로 저장
- 배열에 공간이 부족하면 더 큰 배열을 새로 생성해서 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음에 객체를 추가한다
- 장점) 데이터를 읽어오고 순차적으로 저장하는 데에 효율이 좋다
- 단점) 데이터가 많을 수록 배열 중간에 데이터를 추가, 삭제할 때 작업시간 ↑

### :question: 크기(size)와 용량(capacity)
- 크기(size): 배열이 포함하고 있는 요소의 개수
- 용량(capacity): 배열의 전체 크기

## ArrayList 데이터 추가
<img width="80%" src="https://user-images.githubusercontent.com/86359180/213213695-46126d0a-9703-4430-be59-3c00965104fa.png"/><br>

## ArrayList 데이터 삭제
<img width="80%" src="https://user-images.githubusercontent.com/86359180/213213703-376e5ab3-d558-4520-a491-5dac89e7104b.png"/><br>

### java 11 라이브러리 > remove 할 때 내부적으로 System.arraycopy() 사용
```java
package java.util;
// ... 생략
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    // ... 생략
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }
    // ... 생략
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
    // ... 생략
}
```
- System.arraycopy() 사용
```java
System.arraycopy(src, srcPos, dest, destPos, length);
```
- `Object src` - 원본 배열
- `int srcPos` - 원본 배열의 복사 시작 위치
- `Object dest` - 복사할 배열
- `int destPost` - 복사할 배열의 복사 시작 위치
- `int length` - 복사할 요소의 개수
- `src`의  `srcPos 위치`에서 `dest`의 `destPost 위치`로 `length`만큼 복사

### java 11 라이브러리 > 배열의 크기를 자동으로 늘릴 때 쉬프트 연산(>>)을 사용
```java
    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
            ? newCapacity
            : hugeCapacity(minCapacity);
    }
```
- `oldCapacity >> 1` : `oldCapacity / 2`의 결과와 같다
  - 원래 길이의 50%를 늘려준다

## ArrayList Big-O
|     연산     |             Big-O             |
|:----------:|:-----------------------------:|
|  검색(get)   |             O(1)              |
|  삽입(add)   | 맨 끝에 삽입: O(1)<br>중간에 삽입: O(n) |
| 삭제(remove) |          O(1), O(n)           |

---

# 구현
## 클래스 & 메서드
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

# :large_orange_diamond: 1. MyArrayList Class
```java
public class MyArrayList {

    private Object[] elementData;
    private int listSize = 0;

    public MyArrayList() {
        this.elementData = new Object[]{};
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }
    // ...
}
```

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

## :sparkle: boolean add(int index, Object element): 지정된 위치(index)에 객체 저장
```java
    /**
     * 지정된 위치(index)에 객체 저장
     * @param index 저장할 위치
     * @param element 저장할 객체
     * @return 객체 저장 성공 여부
     */
    public boolean add(int index, Object element) {
        rangeCheckForAdd(index);
        if(elementData.length == listSize) {
            growCapacity();
        }
        for(int i = listSize-1; i >= index; i--) {
            elementData[i+1] = elementData[i];
        }
        elementData[index] = element;
        listSize++;
        return true;
    }

    /**
     * ArrayList index 범위 체크.
     * @param index 체크할 index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.listSize)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+listSize);
    }

    /**
     * ArrayList의 용량(capacity)에 +1
     * @return 용량이 증가된 ArrayList
     */
    private Object[] growCapacity() {
        elementData = Arrays.copyOf(elementData, listSize+1);
        return elementData;
    }
```
### 1. index 범위 체크
```java
/**
 * ArrayList index 범위 체크.
 * @param index 체크할 index
 */
private void rangeCheckForAdd(int index) {
    if (index < 0 || index > this.listSize)
        throw new IndexOutOfBoundsException("Index: "+index+", Size: "+listSize);
}
```

### 2. 배열 용량 체크 및 용량 증가
```java
public boolean add(int index, Object element){
    // ...
    if(elementData.length==listSize){
        growCapacity();
    }
    // ...
}

/**
 * ArrayList의 용량(capacity)에 +1
 * @return 용량이 증가된 ArrayList
 */
private Object[] growCapacity() {
    elementData = Arrays.copyOf(elementData, listSize+1);
    return elementData;
}
```
- Arrays.copyOf()로 기존 배열보다 크기가 1 더 크게 만들어 복사한다

## :sparkle: Object remove(int index): 지정된 위치(index)에 있는 객체를 제거
```java
    /**
     * 지정된 위치(index)에 있는 객체를 제거
     * 제거된 객체를 반환
     * @param index 제거할 객체가 있는 위치
     * @return 제거된 객체
     */
    public Object remove(int index) {
        rangeCheckForAdd(index);

        Object oldValue = elementData[index];

        System.arraycopy(elementData, index + 1, elementData, index , listSize - index - 1);
        listSize--;

        elementData[listSize] = null;
        return oldValue;
    }
```
1. index 범위 체크
2. 제거될 객체를 oldValue에 저장
3. 배열 복사
   - `System.arraycopy(elementData, index + 1, elementData, index , listSize - index - 1);`
   - `elementData[index+1]` 에서 `elementData[index]`로 `listSize - index - 1`만큼 복사
   ```text
   1. int[] arr = {0, 1, 2, 3, 4} 가 있다
   2. System.arraycopy(arr, 3, arr, 2, 2);
      => arr[3]에서 arr[2]로 2개의 데이터를 복사
   3. [0, 1, 2, (3, 4)] arr[3]에서 값 2개(3, 4)를
   4. arr[2]로 복사 -> [0, 1, 3, 4, 4]
   5. arr[4] = null 로 지정
   6. arr = [0, 1, 3, 4, null]
   ```
4. listSize 를 줄여주고
5. 배열의 마지막 값은 null 로 지정 (이유는 3번에)

## :sparkle: boolean remove(Object element): 지정한 객체를 제거. 성공하면 true 반환
```java
    /**
     * 지정한 객체를 제거. 성공하면 true 반환
     * @param element 제거할 객체
     * @return 제거 성공 여부
     */
    public boolean remove(Object element) {

        for(int i = 0; i < listSize; i++) {
            if(elementData[i].equals(element)) {
                remove(i);
                return true;
            }
        }

        return false;
    }
```
- 