package it.unicam.cs.asdl2526.esamesimpledequeue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDequeuePublicTest {

    @Test
    void statoIniziale_isEmpty_e_sizeZero() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        assertTrue(d.isEmpty());
        assertEquals(0, d.getSize());
    }

    @Test
    void addFirst_singoloElemento_readFirstEreadLast() {
        SimpleDequeue<String> d = new SimpleDequeue<>();
        d.addFirst("A");

        assertFalse(d.isEmpty());
        assertEquals(1, d.getSize());
        assertEquals("A", d.readFirst());
        assertEquals("A", d.readLast());
    }

    @Test
    void addLast_singoloElemento_readFirstEreadLast() {
        SimpleDequeue<String> d = new SimpleDequeue<>();
        d.addLast("A");

        assertFalse(d.isEmpty());
        assertEquals(1, d.getSize());
        assertEquals("A", d.readFirst());
        assertEquals("A", d.readLast());
    }

    @Test
    void sequenzaFIFO_addLast_extractFirst() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);

        assertEquals(3, d.getSize());
        assertEquals(Integer.valueOf(1), d.extractFirst());
        assertEquals(2, d.getSize());
        assertEquals(Integer.valueOf(2), d.extractFirst());
        assertEquals(1, d.getSize());
        assertEquals(Integer.valueOf(3), d.extractFirst());

        assertTrue(d.isEmpty());
        assertEquals(0, d.getSize());
    }

    @Test
    void ordineDaHead_addFirst_extractFirst() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3); // head: 3,2,1

        assertEquals(3, d.getSize());
        assertEquals(Integer.valueOf(3), d.extractFirst());
        assertEquals(Integer.valueOf(2), d.extractFirst());
        assertEquals(Integer.valueOf(1), d.extractFirst());

        assertTrue(d.isEmpty());
        assertEquals(0, d.getSize());
    }

    @Test
    void readNonDistruttive_nonCambiaSize() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        d.addLast(1);
        d.addLast(2);

        assertEquals(2, d.getSize());
        assertEquals(Integer.valueOf(1), d.readFirst());
        assertEquals(Integer.valueOf(2), d.readLast());
        assertEquals(2, d.getSize(), "Le read non devono modificare la size");
    }

    @Test
    void operazioniSuVuoto_lancianoEccezione() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
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
    void removeAll_elementoAssente_nonModificaCoda() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);

        assertEquals(3, d.getSize());
        assertEquals(0, d.removeAll(4));
        assertEquals(3, d.getSize());
        assertEquals(Integer.valueOf(1), d.readFirst());
        assertEquals(Integer.valueOf(3), d.readLast());
    }

    @Test
    void removeAll_occorrenzeMultipleSemplici() {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        // 1 2 2 3
        d.addLast(1);
        d.addLast(2);
        d.addLast(2);
        d.addLast(3);

        assertEquals(4, d.getSize());
        assertEquals(2, d.removeAll(2));
        assertEquals(2, d.getSize());

        assertEquals(Integer.valueOf(1), d.extractFirst());
        assertEquals(Integer.valueOf(3), d.extractFirst());
        assertTrue(d.isEmpty());
        assertEquals(0, d.getSize());
    }
}