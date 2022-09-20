# Il metodo `indexOf`

Il metodo `int indexOf(String)` restituisce la posizione della prima occorrenza di una data sottostringa in una stringa;

È necessario passare come argomento della funzione la sottostringa che si vuole ricercare;

Quando la ricerca ha esito negativo, la funzione restituisce `-1`.

es. `"corso-prog".indexOf("ro");`

---

Una seconda versione del metodo effettua la ricerca a partire da una fissata posizione della stringa

È necessario passare come argomenti del metodo

1. La sottostringa che si vuole ricercare;
2. La posizione a partire da cui effettuare la ricerca.

es. `"corso-prog".indexOf("r", 5);`

---

Scrivere un programma che data una stringa `s` controlla se il primo carattere di `s` è
ripetuto nella stringa stampando la posizione in cui è ripetuto o `-1`.