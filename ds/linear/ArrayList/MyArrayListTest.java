package ds.linear.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    static MyArrayList list;

    @BeforeEach
    public void initTest() {
        list = new MyArrayList(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    public void testToString() {
        System.out.println(list.toString());
        Assertions.assertEquals("[1, 2, 3, 4, 5]", list.toString());
    }

    @Test
    public void testAddIndex() {
        list.add(0, 0);
        list.add(3, 30);
        list.add(5, 50);
        list.add(8, 80);
        System.out.println(list.toString());
        Assertions.assertEquals("[0, 1, 2, 30, 3, 50, 4, 5, 80]", list.toString());
    }
}
