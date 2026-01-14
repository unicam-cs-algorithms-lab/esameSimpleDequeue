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
 * <p>
 * <p>
 * Viene poi richiesto un metodo removeAll che rimuove dalla coda tutti gli
 * elementi
 * uguali a un elemento dato secondo il metodo equals della classe E.
 *
 * </p>
 * NOTA BENE: Tutti i metodi tranne removeAll devono essere
 * implementati in modo che abbiano complessità asintotica O(1). Il metodo
 * removeAll può avere complessità asintotica O(n).
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
        // TODO implementare
    }

    /**
     * Aggiunge un elemento alla coda alla fine, nella parte destra (tail).
     *
     * @param element l'elemento da aggiungere
     */
    public void addLast(E element) {
        // TODO implementare
    }

    /**
     * Restituisce il primo elemento della coda sulla sinistra (head), ma
     * non lo estrae.
     *
     * @return il primo elemento della coda sulla sinistra
     * @throws IllegalStateException se la coda è vuota
     */
    public E readFirst() {
        // TODO implementare
        return null;
    }

    /**
     * Restituisce l'ultimo elemento della coda sulla destra (tail), ma
     * non lo estrae.
     *
     * @return l'ultimo elemento sulla destra (tail)
     * @throws IllegalStateException se la coda è vuota
     */
    public E readLast() {
        // TODO implementare
        return null;
    }

    /**
     * Estrae e restituisce il primo elemento della coda sulla sinistra
     * (head).
     *
     * @return il primo elemento della coda sulla sinistra
     * @throws IllegalStateException se la coda è vuota
     */
    public E extractFirst() {
        // TODO implementare
        return null;
    }

    /**
     * Estrae e restituisce l'ultimo elemento della coda sulla destra
     * (tail).
     *
     * @return il primo elemento della coda sulla sinistra
     * @throws IllegalStateException se la coda è vuota
     */
    public E extractLast() {
        // TODO implementare
        return null;
    }

    /**
     * Rimuove tutte le occorrenze dell'elemento passato come parametro.
     *
     * @param element elemento da rimuovere
     * @return numero di elementi rimossi
     */
    public int removeAll(E element) {
        // TODO implementare
        return -1;
    }

    /**
     * Determina se la coda è vuota.
     *
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
