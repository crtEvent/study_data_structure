package ds.linear.ArrayList;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Vector;

public class MyArrayListTest {
    static MyArrayList list;

    @Test
    public void test() {
        Vector v = new Vector(5);
        v.add("1");
        v.add("2");
        v.add("3");
        System.out.println(System.identityHashCode(v));

        v.trimToSize();
        System.out.println(System.identityHashCode(v));
    }

    @Nested
    class Test_01 {

        Throwable exception;

        @BeforeEach
        public void initTest() {
            list = new MyArrayList(50);
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

        @Test
        public void testRemoveByIndex() {
            list.remove(2);
            list.remove(0);
            list.remove(2);
            System.out.println(list.toString());
            Assertions.assertEquals("[2, 4]", list.toString());

            exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                list.remove(-5);
            });
            System.out.println(exception);

            exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                list.remove(99);
            });
            System.out.println(exception);
        }

        @Test
        public void testRemoveByObject() {
            list.remove(new Integer(3));
            list.remove(new Integer(1));
            list.remove(new Integer(5));
            System.out.println(list.toString());
            Assertions.assertEquals("[2, 4]", list.toString());
            
            // 없는 값을 제거하려고 할 경우
            Assertions.assertTrue(!list.remove(new Integer(0)));
        }
        @Test
        public void testIndexOf() {
            int index;

            index = list.indexOf(null);
            Assertions.assertEquals(-1, index);

            index = list.indexOf(5);
            Assertions.assertEquals(4, index);

            MyArrayList list2 = new MyArrayList(10);
            list2.add(1);
            list2.add(null);
            list2.add(2);
            index = list2.indexOf(null);
            Assertions.assertEquals(1, index);
        }
    }
}
