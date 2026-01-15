package it.unicam.cs.asdl2526.esamesimpledequeue;

/**
 * Algoritmi e Strutture Dati - Laboratorio
 * <p>
 * Prova di Esame
 * <p>
 * Questa classe deve fornire una struttura dati "coda a doppia entrata"
 * utilizzando una lista concatenata doppia (con puntatori next e previous)
 * <p>
 * Gli elementi sono un generico tipo E.
 * <p>
 * I metodi principali servono a inserire un elemento dalla parte della head
 * oppure dalla parte della tail. I metodi inversi invece estraggono un
 * elemento dalla parte della head oppure dalla parte della tail.
 * Completano i metodi che leggono la head o la tail senza estrarli e i
 * metodi di servizio sulla size e sulla coda vuota.
 *
 * NOTA BENE: Tutti i metodi devono essere implementati in modo che abbiano
 * complessità asintotica O(1).
 */
public class SimpleDequeue<E> {

    /* Primo elemento sulla sinistra, null nel caso di coda vuota */
    private Node<E> head;
    /* Ultimo elemento sulla destra, null nel caso di coda vuota */
    private Node<E> tail;
    /* Numero di elementi corrente */
    private int size;

    /**
     * Crea una coda a doppia entrata vuota
     */
    public SimpleDequeue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /*
    Classe interna per i nodi della lista concatenata doppia.
     */
    private static class Node<E> {
        // Elemento del nodo
        private E item;
        /* prossimo nodo nella lista concatenata doppia, null se questo è
        l'ultimo elemento sulla destra.
         */
        private Node<E> next;
        /* nodo precedente nella lista concatenata doppia, null se questo è
         il primo elemento sulla sinistra.
         */
        private Node<E> previous;

        /*
        Costruisce un nodo con tutte le informazioni.
         */
        Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }

        /*
        Costruisce un nodo con solo item mettendo a null i puntatori.
         */
        Node(E item) {
            this.item = item;
        }
    }

    /**
     * Aggiunge un elemento alla coda all'inizio, nella parte sinistra (head).
     *
     * @param element l'elemento da aggiungere
     */
    public void addFirst(E element) {
        if (this.head == null) {
            this.head = new Node<E>(element);
            this.tail = this.head;
        } else {
            Node<E> tmp = this.head;
            this.head = new Node<E>(element, this.head, null);
            tmp.previous = this.head;
        }
        this.size++;
    }

    /**
     * Aggiunge un elemento alla coda alla fine, nella parte destra (tail).
     *
     * @param element l'elemento da aggiungere
     */
    public void addLast(E element) {
        if (this.head == null) {
            this.tail = new Node<E>(element);
            this.head = this.tail;
        } else {
            Node<E> tmp = this.tail;
            this.tail = new Node<E>(element, null, this.tail);
            tmp.next = this.tail;
        }
        this.size++;
    }

    /**
     * Restituisce il primo elemento della coda sulla sinistra (head), ma
     * non lo estrae.
     *
     * @return il primo elemento della coda sulla sinistra
     * @throws IllegalStateException se la coda è vuota
     */
    public E readFirst() {
        if (size == 0) throw new IllegalStateException("Richiesta di primo " +
                "elemento di coda vuota");
        return this.head.item;
    }

    /**
     * Restituisce l'ultimo elemento della coda sulla destra (tail), ma
     * non lo estrae.
     *
     * @return l'ultimo elemento sulla destra (tail)
     * @throws IllegalStateException se la coda è vuota
     */
    public E readLast() {
        if (size == 0) throw new IllegalStateException("Richiesta di ultimo" +
                "elemento di coda vuota");
        return this.tail.item;
    }

    /**
     * Estrae e restituisce il primo elemento della coda sulla sinistra
     * (head).
     *
     * @return il primo elemento della coda sulla sinistra
     * @throws IllegalStateException se la coda è vuota
     */
    public E extractFirst() {
        if (size == 0) throw new IllegalStateException("Richiesta di primo " +
                "elemento di coda vuota");
        if (size == 1) {
            // Caso di coda che si svuota
            E tmp = this.head.item;
            this.head = null;
            this.tail = null;
            this.size = 0;
            return tmp;
        }
        // la coda non si svuota
        E tmp = this.head.item;
        this.head = this.head.next;
        this.head.previous = null;
        this.size--;
        return tmp;
    }

    /**
     * Estrae e restituisce l'ultimo elemento della coda sulla destra
     * (tail).
     *
     * @return il primo elemento della coda sulla sinistra
     * @throws IllegalStateException se la coda è vuota
     */
    public E extractLast() {
        if (size == 0) throw new IllegalStateException("Richiesta di ultimo" +
                "elemento di coda vuota");
        if (size == 1) {
            // Caso di coda che si svuota
            E tmp = this.head.item;
            this.head = null;
            this.tail = null;
            this.size = 0;
            return tmp;
        }
        // la coda non si svuota
        E tmp = this.tail.item;
        this.tail = this.tail.previous;
        this.tail.next = null;
        this.size--;
        return tmp;
    }

    /**
     * Rimuove tutte le occorrenze dell'elemento passato come parametro.
     *
     * @param element elemento da rimuovere
     * @return numero di elementi rimossi
     */
    public int removeAll(E element) {
        int removed = 0;
        Node<E> current = this.head;

        while (current != null) {
            Node<E> next = current.next;

            if (current.item.equals(element)) {
                // rimozione del nodo current
                if (current.previous == null) {
                    // rimozione in testa
                    this.head = current.next;
                    if (this.head != null) {
                        this.head.previous = null;
                    }
                } else {
                    current.previous.next = current.next;
                }

                if (current.next == null) {
                    // rimozione in coda
                    this.tail = current.previous;
                    if (this.tail != null) {
                        this.tail.next = null;
                    }
                } else {
                    current.next.previous = current.previous;
                }

                this.size--;
                removed++;
            }

            current = next;
        }

        return removed;
    }

    /**
     * Determina se la coda è vuota.
     * @return se la coda è vuota.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Restituisce il numero corrente di elementi della coda.
     *
     * @return il numero di elementi
     */
    public int getSize() {
        return this.size;
    }

}
