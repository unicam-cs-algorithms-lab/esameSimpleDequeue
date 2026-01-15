package it.unicam.cs.asdl2526.esamesimpledequeue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecretRemoveAllAdvancedTest {

    @Test
    void removeAll_headAndTailOccurrences() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        // 2 1 2 3 2
        d.addLast(2);
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(2);

        assertEquals(5, d.getSize());
        assertEquals(3, d.removeAll(2));
        assertEquals(2, d.getSize());
        assertEquals(Integer.valueOf(1), d.extractFirst());
        assertEquals(Integer.valueOf(3), d.extractFirst());
        assertTrue(d.isEmpty());
    }

    @Test
    void removeAll_longConsecutiveBlock() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        // 1 2 2 2 2 3
        d.addLast(1);
        d.addLast(2);
        d.addLast(2);
        d.addLast(2);
        d.addLast(2);
        d.addLast(3);

        assertEquals(6, d.getSize());
        assertEquals(4, d.removeAll(2));
        assertEquals(2, d.getSize());
        assertEquals(Integer.valueOf(1), d.extractFirst());
        assertEquals(Integer.valueOf(3), d.extractFirst());
        assertTrue(d.isEmpty());
    }

    @Test
    void removeAll_removeEverything_thenEmptyBehavesCorrectly() {
        SimpleDequeue<String> d = new SimpleDequeue<>();
        d.addLast("A");
        d.addLast("A");
        d.addLast("A");

        assertEquals(3, d.removeAll("A"));
        assertTrue(d.isEmpty());
        assertEquals(0, d.getSize());

        assertAll(
                () -> assertThrows(IllegalStateException.class, d::readFirst),
                () -> assertThrows(IllegalStateException.class, d::readLast),
                () -> assertThrows(IllegalStateException.class, d::extractFirst),
                () -> assertThrows(IllegalStateException.class, d::extractLast)
        );
    }

    @Test
    void removeAll_thenContinueUsingDeque() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        // 1 2 2 3
        d.addLast(1);
        d.addLast(2);
        d.addLast(2);
        d.addLast(3);

        assertEquals(2, d.removeAll(2));
        assertEquals(2, d.getSize());

        d.addFirst(0); // 0 1 3
        d.addLast(4);  // 0 1 3 4
        assertEquals(4, d.getSize());

        assertEquals(Integer.valueOf(0), d.extractFirst());
        assertEquals(Integer.valueOf(4), d.extractLast());
        assertEquals(Integer.valueOf(1), d.extractFirst());
        assertEquals(Integer.valueOf(3), d.extractLast());
        assertTrue(d.isEmpty());
    }
}