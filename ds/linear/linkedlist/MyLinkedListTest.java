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

}
