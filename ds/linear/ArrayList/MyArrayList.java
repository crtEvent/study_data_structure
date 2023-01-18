package ds.linear.ArrayList;

import java.util.Arrays;

public class MyArrayList {

    private Object[] elementData;
    private int listSize = 0;

    public MyArrayList() {
        this.elementData = new Object[]{};
    }

    public MyArrayList(int initialCapacity) {
        if(initialCapacity >= 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("[Error] Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     * ArrayList에 저장된 객체의 개수 반환
     * @return
     */
    public int size() {
        return listSize;
    }

    /**
     * ArrayList가 비어있는지 확인
     * @return 비어있으면 true 반환
     */
    public boolean isEmpty() {
        return listSize == 0;
    }

    /**
     * 지정된 객체가 저장된 위치를 찾아 반환
     * @param element 위치를 찾으려고 하는 객체
     * @return 객체가 저장된 위치
     */
    public int indexOf(Object element) {
        return 0;
    }

    /**
     * 객체가 저장된 위치를 끝부터 역방향으로 검색해서 반환
     * @param element 위치를 찾으려고 하는 객체
     * @return 객체가 저장된 위치
     */
    public int lastIndexOf(Object element) {
        return 0;
    }

    /**
     * 지정된 객체가 ArrayList에 있는지 확인
     * @param element ArrayList에 있는지 확인할 객체
     * @return 객체가 존재하는지 여부
     */
    public boolean contains(Object element) {
        return false;
    }

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

    /**
     * 지정된 위치(index)에 저장된 객체 반환
     * @param index 객체가 저장된 위치
     * @return 지정된 위치(index)에 저장된 객체
     */
    public Object get(int index) {
        return null;
    }

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

    /**
     * 용량을 크기에 맞게 줄인다 (빈 공간을 없앤다)
     */
    public void trimSize() {

    }

    /**
     * ArrayList의 용량이 최소한(minCapacity)가 되도록 한다
     * @param minCapacity 설정할 최소 용량
     */
    public void ensureCapacity(int minCapacity) {

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < listSize-1; i++) {
            sb.append(elementData[i]).append(", ");
        }
        sb.append(elementData[listSize-1]).append("]");
        return sb.toString();
    }
}
