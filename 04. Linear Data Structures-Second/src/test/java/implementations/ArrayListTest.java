package implementations;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void addShouldIncreaseCount() {
        ArrayListOld<Integer> numbers = new ArrayListOld<>();
        numbers.add(1);
        assertEquals(1, numbers.size());
    }

    @Test
    public void addShouldIncreaseSize() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertEquals(100, strings.size());
    }

    @Test
    public void removeShouldReduceSize() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        int n = 50;
        while (n-- > 0) {
            strings.remove(0);
        }

        assertEquals(50, strings.size());
    }

    @Test
    public void testIndexOfShouldReturnMinusOneForEmptyList() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        assertEquals(-1, strings.indexOf("1"));
    }

    @Test
    public void testIndexOfShouldReturnCorrectIndex() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertEquals(73, strings.indexOf("73"));
    }

    @Test
    public void testContainsReturnFalseForEmptyList() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        assertFalse(strings.contains("1"));
        strings.add("1");
        assertTrue(strings.contains("1"));
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertTrue(strings.contains("73"));
    }

    @Test
    public void testSizeShouldReturnZeroEmptyList() {
        ArrayListOld<String> strings = new ArrayListOld<>();
        assertEquals(0, strings.size());
        strings.add("SingleElement");
        assertEquals(1, strings.size());
    }

    @Test
    public void testSizeShouldReturnOneHundred() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        assertEquals(100, strings.size());
    }

    @Test
    public void testIsEmptyReturnTrueEmptyList() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        assertTrue(strings.isEmpty());
    }

    @Test
    public void testIsEmptyShouldReturnFalse() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        assertTrue(new ArrayListOld<>().isEmpty());
        assertFalse(strings.isEmpty());
    }

    @Test
    public void testIterator() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
            stringBuilder.append(i);
        }

        String values = stringBuilder.toString();

        Iterator<String> iter = strings.iterator();
        assertNotNull(iter);
        int counter = 0;
        for (iter = strings.iterator();iter.hasNext();) {
            if (values.contains(iter.next())) {
                counter++;
            } else {
                counter = -1;
                break;
            }
        }

        assertEquals(strings.size(), counter);
    }

    @Test
    public void testRemoveShouldReturnCorrectElementsAndShiftTheRemaining() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
            stringBuilder.append(i);
        }

        String values = stringBuilder.toString();

        String removed = strings.remove(0);
        assertNotNull(removed);
        int index = 0;
        for (int i = 0; i < values.length(); i++) {
            assertEquals(values.charAt(i), removed.charAt(index++));
            if (index == removed.length() && i < values.length() - 1) {
                index = 0;
                removed = strings.remove(0);
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldThrowWithInvalidIndex() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        strings.remove(strings.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldThrowWithInvalidIndexZero() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        strings.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveShouldThrowWithInvalidIndexMinusOne() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        strings.remove(-1);
    }

    @Test
    public void testGetShouldReturnTheCorrectElement() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }
        assertEquals("99", strings.get(99));
    }

    @Test
    public void testSetShouldChangeTheElement() {
        ArrayListOld<String> strings = new ArrayListOld<>();

        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
        }

        strings.set(99, "666");
        assertEquals("666", strings.get(99));
    }

    @Test
    public void addAndGetMultipleElements() {
        ArrayListOld<Integer> list = new ArrayListOld<Integer>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (Integer i = 0; i < 100; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    public void testInsertShouldSetCorrectlyAndShiftRestToTheRight() {
        ArrayListOld<String> strings = new ArrayListOld<>();


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            strings.add(String.valueOf(i));
            if (i == 50) {
                stringBuilder.append("666");
            }
            stringBuilder.append(i);
        }

        strings.add(50, "666");

        assertEquals("666", strings.get(50));

        String values = stringBuilder.toString();

        StringBuilder sb = new StringBuilder();

        for (String number : strings) {
            sb.append(number);
        }

        assertEquals(values, sb.toString());
    }
}