package ds.linear.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    MyLinkedList list;

    @Test
    public void testAddLast() {
        list = new MyLinkedList();
        System.out.println(list.toString());
        Assertions.assertEquals("[]", list.toString());

        list.addLast(new Integer(1));
        System.out.println(list.toString());
        Assertions.assertEquals("[1]", list.toString());

        list.addLast(new Integer(2));
        list.addLast(new Integer(3));
        list.addLast(new Integer(4));
        System.out.println(list.toString());
        Assertions.assertEquals("[1, 2, 3, 4]", list.toString());
    }

    @Test
    public void testAddFirst() {
        list = new MyLinkedList();
        System.out.println(list.toString());
        Assertions.assertEquals("[]", list.toString());

        list.addFirst(new Integer(1));
        System.out.println(list.toString());
        Assertions.assertEquals("[1]", list.toString());

        list.addFirst(new Integer(2));
        list.addFirst(new Integer(3));
        list.addFirst(new Integer(4));
        System.out.println(list.toString());
        Assertions.assertEquals("[4, 3, 2, 1]", list.toString());
    }

    @Test
    public void testAdd() {
        list = new MyLinkedList();
        System.out.println(list.toString());
        Assertions.assertEquals("[]", list.toString());

        list.add(0, new Integer(1));
        System.out.println(list.toString());
        Assertions.assertEquals("[1]", list.toString());

        list.add(0, new Integer(2)); // [2, 1]
        list.add(1, new Integer(3)); // [2, 3, 1]
        list.add(2, new Integer(4)); // [2, 3, 4, 1]
        list.add(3, new Integer(5)); // [2, 3, 4, 5, 1]
        System.out.println(list.toString());
        Assertions.assertEquals("[2, 3, 4, 5, 1]", list.toString());

        // 만약 index로 음수 값이나 list 크기보다 큰 값이 들어온다면?
        list.add(-3, new Integer(6));
        System.out.println(list.toString());
        Assertions.assertEquals("[6, 2, 3, 4, 5, 1]", list.toString());

        list.add(6, new Integer(7));
        System.out.println(list.toString());
        Assertions.assertEquals("[6, 2, 3, 4, 5, 1, 7]", list.toString());

        list.add(150, new Integer(8));
        System.out.println(list.toString());
        Assertions.assertEquals("[6, 2, 3, 4, 5, 1, 7, 8]", list.toString());
    }

    @Test
    public void testRemoveFirst() {
        list = new MyLinkedList();
        list.addLast(new Integer(1));
        list.addLast(new Integer(2));
        list.addLast(new Integer(3));
        list.addLast(new Integer(4));
        System.out.println("test 전: "+list.toString());
        Assertions.assertEquals("[1, 2, 3, 4]", list.toString());

        int removedValue = (int) list.removeFirst();
        System.out.println("제거된 Node의 date: "+removedValue);
        System.out.println("removeFirst() 후: "+list.toString());
        Assertions.assertEquals(1, removedValue);
        Assertions.assertEquals("[2, 3, 4]", list.toString());

        removedValue = (int) list.removeFirst();
        System.out.println("제거된 Node의 date: "+removedValue);
        System.out.println("removeFirst() 후: "+list.toString());
        Assertions.assertEquals(2, removedValue);
        Assertions.assertEquals("[3, 4]", list.toString());

        // 만약 남은 Node가 0인데 계속 제거한다면?
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        System.out.println("모든 node 제거 후: "+list.toString());
        Assertions.assertEquals("[]", list.toString());

    }

}
