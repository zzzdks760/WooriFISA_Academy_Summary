package dev.syntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MyArrayListTest {
	
	protected List<Integer> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
	}

	@Test
    @DisplayName("#1-2. add(E element) 테스트")
    void add() {
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        assertEquals(19, list.size());
    }

//    @Test
//    @DisplayName("#1-3. T get(int index) 테스트")
//    void get() {
//        System.out.println(list.get(1)); // 2
//        assertEquals(2, list.get(1));
//    }
//
//    @Test
//    @DisplayName("#1-4. T set(int index, T element) 테스트")
//    void set() {
//        Integer val = list.set(1, 5);
//        System.out.println(val); // 2
//
//        assertEquals(2, val);
//
//        val = list.set(0, 6);
//        System.out.println(val); // 1
//        assertEquals(1, val);
//
//        assertEquals(list.get(0), 6);
//        assertEquals(list.get(1), 5);
//    }
//
//    @Test
//    @DisplayName("#1-4. 존재하지 않는 인덱스로 접근할 경우 ArrayIndexOutOf~ 예외를 던진다.")
//    void setWithException() {
////        try {
////            list.set(-1, 0);
////        } catch (IndexOutOfBoundsException e) {
////            System.out.println(e);
////        }
//
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.set(-1, 0));
//    }
//
//    @Test
//    @DisplayName("#1-5. indexOf(Object o) 테스트")
//    void indexOf() {
//        assertEquals(0, list.indexOf(1));
//        assertEquals(1, list.indexOf(2));
//        assertEquals(2, list.indexOf(3));
//
//        assertEquals(-1, list.indexOf(4));
//    }
//
//    @Test
//    @DisplayName("#1-6. add(int index, E element) 테스트")
//    void addWithIndex() {
//        list.add(1, 5);
//
//        assertEquals(5, list.get(1));
//        assertEquals(4, list.size());
//
//    }
//
//    @Test
//    @DisplayName("#1-7. remove(int index) 테스트")
//    void remove() {
//        Integer val = list.remove(1);
//        assertEquals(2, val);
//
//        assertEquals(2, list.size());
//        assertEquals(3, list.get(1));
//    }
//
//    @Test
//    @DisplayName("#1-8. remove(Object o) 테스트")
//    void removeWithObject() {
//        boolean flag = list.remove(Integer.valueOf(2));
//        assertTrue(flag);
//        assertEquals(2, list.size());
//        assertEquals(3, list.get(1));
//    }

}
