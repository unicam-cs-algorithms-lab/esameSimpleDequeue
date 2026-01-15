package it.unicam.cs.asdl2526.esamesimpledequeue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Utility per stress test deterministici con oracolo ArrayDeque.
 * Tenere in src/test e NON distribuire agli studenti.
 */
final class SecretOracleUtils {

    private SecretOracleUtils() {
        // no instances
    }

    /**
     * Esegue una sequenza deterministica di operazioni su SimpleDequeue e su un oracolo ArrayDeque,
     * confrontando size, isEmpty, elementi in testa/coda e risultati/exception di extract.
     */
    static void runStressTest(long seed, int steps, int valueRange) {
        SimpleDequeue<Integer> d = new SimpleDequeue<>();
        ArrayDeque<Integer> oracle = new ArrayDeque<>();
        Random rnd = new Random(seed);

        for (int i = 0; i < steps; i++) {
            int op = rnd.nextInt(100);

            if (op < 20) {
                // addFirst
                Integer v = rnd.nextInt(valueRange);
                d.addFirst(v);
                oracle.addFirst(v);

            } else if (op < 40) {
                // addLast
                Integer v = rnd.nextInt(valueRange);
                d.addLast(v);
                oracle.addLast(v);

            } else if (op < 52) {
                // readFirst
                if (oracle.isEmpty()) {
                    assertThrows(IllegalStateException.class, d::readFirst);
                } else {
                    assertEquals(oracle.peekFirst(), d.readFirst());
                }

            } else if (op < 64) {
                // readLast
                if (oracle.isEmpty()) {
                    assertThrows(IllegalStateException.class, d::readLast);
                } else {
                    assertEquals(oracle.peekLast(), d.readLast());
                }

            } else if (op < 76) {
                // extractFirst
                if (oracle.isEmpty()) {
                    assertThrows(IllegalStateException.class, d::extractFirst);
                } else {
                    assertEquals(oracle.removeFirst(), d.extractFirst());
                }

            } else if (op < 88) {
                // extractLast
                if (oracle.isEmpty()) {
                    assertThrows(IllegalStateException.class, d::extractLast);
                } else {
                    assertEquals(oracle.removeLast(), d.extractLast());
                }

            } else {
                // removeAll (O(n) ammessa)
                Integer target = rnd.nextInt(valueRange);
                int expectedRemoved = oracleRemoveAll(oracle, target);
                int removed = d.removeAll(target);
                assertEquals(expectedRemoved, removed, "removeAll deve restituire il numero di elementi rimossi");
            }

            // Invarianti dopo OGNI operazione
            assertEquals(oracle.size(), d.getSize(), "Size incoerente dopo operazione " + i);
            assertEquals(oracle.isEmpty(), d.isEmpty(), "isEmpty incoerente dopo operazione " + i);

            if (oracle.isEmpty()) {
                assertThrows(IllegalStateException.class, d::readFirst);
                assertThrows(IllegalStateException.class, d::readLast);
            } else {
                assertEquals(oracle.peekFirst(), d.readFirst(), "Head incoerente dopo operazione " + i);
                assertEquals(oracle.peekLast(), d.readLast(), "Tail incoerente dopo operazione " + i);
            }

            // Ogni tanto: controllo profondo del contenuto
            if (i % 50 == 0) {
                assertEquals(snapshot(oracle), snapshot(d), "Contenuto diverso dopo operazione " + i);
            }
        }
    }

    private static int oracleRemoveAll(ArrayDeque<Integer> oracle, Integer target) {
        int removed = 0;
        ArrayDeque<Integer> tmp = new ArrayDeque<>();

        while (!oracle.isEmpty()) {
            Integer x = oracle.removeFirst();
            if (x.equals(target)) removed++;
            else tmp.addLast(x);
        }

        oracle.addAll(tmp);
        return removed;
    }

    private static List<Integer> snapshot(ArrayDeque<Integer> oracle) {
        return new ArrayList<>(oracle);
    }

    /**
     * Snapshot senza iterator esposto: estraiamo da una copia temporanea ottenuta
     * spostando gli elementi e ripristinando (O(n)), accettabile in un test segreto.
     */
    private static List<Integer> snapshot(SimpleDequeue<Integer> d) {
        List<Integer> out = new ArrayList<>();
        SimpleDequeue<Integer> tmp = new SimpleDequeue<>();

        while (!d.isEmpty()) {
            Integer x = d.extractFirst();
            out.add(x);
            tmp.addLast(x);
        }
        while (!tmp.isEmpty()) {
            d.addLast(tmp.extractFirst());
        }
        return out;
    }
}