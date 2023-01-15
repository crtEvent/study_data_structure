package ds.linear.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    static MyArrayList list;

    @BeforeEach
    public void initTest() {
        list = new MyArrayList(100);
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
}
