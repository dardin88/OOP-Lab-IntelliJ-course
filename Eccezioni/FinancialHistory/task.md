# Storia Finanziaria

Si definisca una classe `FinancialHistory` le cui istanze conservino informazioni relative alla gestione di un bilancio.
La classe deve fornire i seguenti costruttori e metodi:

- un costruttore con argomento `double` e un oggetto `Person` che rappresenti l'ammontare iniziale a disposizione e
  l’utente a cui si riferisce il bilancio;
- un metodo `void receiveFrom(int amount, String source)` che registri una nuova entrata di `amount` ricevuta
  da `source` (ad esempio, `"stipendio"`);
- un metodo void `spendFor(int amount, String reason)` che registri una nuova uscita di `amount` spesa per `reason` (ad
  esempio, `"affitto"`);
- un metodo `double cashOnHand()` che restituisca l’`amount` disponibile;
- un metodo `double totalReceivedFrom(String source)` che restituisca il totale delle entrate ricevute da `source`;
- un metodo `double totalSpentFor(String reason)` che restituisca il totale delle uscite spese per `reason`;
- un metodo che stampi entrate e uscite, includendo `source` o `reason` e `amount`.

NB: le liste delle entrate e delle uscite possono essere implementate utilizzando una `List` e creando un’unica
classe `Movement` contenente al suo interno una stringa `description` e l’`amount`.
Un’entrata sarà rappresentata da un `Movement` con `amount` positivo, mentre un’uscita avrà un valore negativo.

Si trattino con eccezioni delle seguenti situazioni:
- "bilancio in rosso" nel costruttore (i.e., imposta il saldo in negativo);
- "bilancio in rosso” (cioè si tenta di spendere più di quel che si ha).

Implementare i casi di test per collaudare il tutto.