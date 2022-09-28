# La classe `String`

In Java una stringa è una sequenza finita di caratteri racchiusa tra virgolette, come "buongiorno"
(le virgolette non fanno parte della stringa).

Per dichiarare una variabile stringa

```
String vuota = "";        // stringa con valore nullo
String nome = "Luigi";    // stringa con valore Luigi
```

Una stringa vuota è un oggetto `String` che rappresenta una sequenza vuota di caratteri, cioè una stringa di lunghezza
zero.

La stringa vuota è denotata dal letterale "".

---

Il metodo `int length()` della classe String calcola la lunghezza della stringa, cioè il numero di caratteri che
compongono la stringa.

La concatenazione di stringhe, a partire da due stringhe, permette di ottenere una stringa il cui valore è dato dalla
sequenza di caratteri della prima stringa seguita dalla sequenza di caratteri della seconda stringa.

---

Il metodo `String concat(String x)` della classe `String` implementa la concatenazione di stringhe.

`concat` crea e restituisce un nuovo oggetto `String` composto dai caratteri della stringa su cui il metodo viene
invocato
seguiti dai caratteri della stringa argomento `x`.

```
String s1="barba", s2="gianni", s3;
s3 = s1.concat(s2);                  // s3 vale "barbagianni"
```

---

La concatenazione di stringhe si può effettuare anche tramite l’operatore `+` (inteso come concatenazione).
Ad esempio

```
System.out.println(s1 + s2); // stampa "barbagianni"
System.out.println("la "+ s1 + " di " + s2);
```

L’operatore `+` è detto sovraccarico (i.e., overloaded) perché opera su numeri e stringhe.

Questo è un esempio di overloading predefinito.

---

Le posizioni dei caratteri in una stringa sono numerate a partire da `0`.

Per una panoramica dei metodi della classe `String`
vedere la [documentazione ufficiale](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)

Un esempio di uso di substring e concatenazione è disponibile
[qui](course://Lab_01/StringClass/src/SubstringConcatExample.java).