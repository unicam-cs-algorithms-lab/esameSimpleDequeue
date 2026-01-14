## Esame di Algoritmi e Strutture Dati – Laboratorio

### Condizioni dell'esame

- **Tempo a disposizione**: **1 ora**
- **È consentito** utilizzare **solo** l'IDE IntelliJ IDEA disponibile nel
  Thin Client.
- **Non è consentito** utilizzare materiale cartaceo.
- **Non è consentito** navigare in Internet con il browser o altre
  applicazioni.

---

### Istruzioni

1. Scaricare il codice in formato `.zip` dalla domanda Moodle nella cartella
   del Thin Client `C:\Users\proprionome.propriocognome`
2. Scompattare lo zip.
3. Aprire con IntelliJ IDEA la cartella scompattata.
4. L'IDE dovrebbe riconoscere automaticamente il progetto come **Maven** e
   scaricare le dipendenze necessarie per l’esecuzione dei test. Questo può
   richiedere un po' di tempo.
5. Leggere attentamente la descrizione delle classi fornite e del lavoro da
   svolgere in questo file `README.md` (e nella domanda su Moodle).
6. Implementare **esclusivamente** i metodi contrassegnati nel codice con
   `// TODO implementare`.
7. Sono messi a disposizione alcuni **test JUnit di base** per verificare le
   funzionalità richieste.
   **I test forniti non sono tutti quelli utilizzati in fase di valutazione.**

---

### Descrizione delle classi fornite e del lavoro da fare

Nel progetto è fornita la classe:

- **`SimpleDequeue<E>`**

che rappresenta una **coda a doppia entrata (deque)** parametrica sul tipo
generico `E`.

La struttura dati deve essere implementata utilizzando una **lista doppiamente
concatenata**, in cui ogni nodo contiene:

- un riferimento all’elemento memorizzato,
- un riferimento al nodo successivo (`next`),
- un riferimento al nodo precedente (`previous`).

La coda mantiene esplicitamente:

- un riferimento al **primo elemento** (head, lato sinistro),
- un riferimento all’**ultimo elemento** (tail, lato destro),
- il **numero corrente di elementi** presenti.

---

#### Funzionalità richieste

La classe deve supportare le seguenti operazioni:

- inserimento di un elemento:
   - all’inizio della coda (lato **head**),
   - alla fine della coda (lato **tail**);
- lettura del primo o dell’ultimo elemento **senza estrazione**;
- estrazione del primo o dell’ultimo elemento;
- rimozione di tutte le occorrenze di un elemento;
- verifica se la coda è vuota;
- restituzione del numero di elementi presenti.

---

#### Metodi da implementare

Lo studente deve completare **esclusivamente** i seguenti metodi pubblici,
contrassegnati nel codice con:

```
// TODO implementare
```

In particolare:

- `public void addFirst(E element)`
- `public void addLast(E element)`
- `public E readFirst()`
- `public E readLast()`
- `public E extractFirst()`
- `public E extractLast()`
- `public int removeAll(E element)`

I metodi:

- `public boolean isEmpty()`
- `public int getSize()`

sono **già implementati e non devono essere modificati**.

---

### Specifica del metodo `removeAll`

Il metodo:

- `public int removeAll(E element)`

deve rimuovere **tutte le occorrenze** dell’elemento passato come parametro
dalla coda.

- Il confronto tra elementi deve avvenire tramite il metodo `equals`.
- Il metodo deve restituire il **numero di elementi rimossi**.
- Dopo l’esecuzione del metodo, la struttura dati deve risultare **coerente**,
  con puntatori `next` e `previous` correttamente aggiornati.
- È ammessa una **complessità asintotica O(n)**.

Il metodo deve gestire correttamente tutti i casi limite, inclusi:

- coda vuota,
- rimozione del primo e/o dell’ultimo elemento,
- rimozione di occorrenze consecutive,
- rimozione di tutti gli elementi della coda.

---

#### Vincoli e specifiche generali

- Tutti i metodi, **ad eccezione di `removeAll`**, devono avere **complessità
  asintotica O(1)**.
- Non è consentito attraversare la lista nei metodi che non lo richiedono.
- Nei metodi di lettura ed estrazione, se la coda è vuota, deve essere
  lanciata una `IllegalStateException`, come specificato nei commenti del
  codice.
- Il comportamento deve essere corretto in tutti i casi limite (coda vuota,
  coda con un solo elemento, sequenze miste di operazioni).

---

#### Test

Nel progetto sono forniti **alcuni test JUnit di base** che verificano parte
delle funzionalità richieste.

Il superamento di tutti i test forniti è **necessario ma non sufficiente** per
ottenere il punteggio massimo.

---

### Consegna delle classi

1. Controllare che non ci siano errori di compilazione.
2. Controllare che tutti i test forniti passino correttamente.
3. Allegare **solo i seguenti file** nella risposta al compito Moodle:
   - `SimpleDequeue.java`
4. **Non devono essere consegnate**:
   - le classi che non contengono `// TODO implementare`,
   - le classi di test.
5. Terminare la sessione e uscire dalla stanza.
