# Borsa

Implementare e testare la classe `Purse` come collezione di `Coin`:

- una moneta è un’istanza della classe `Coin`;
- gli oggetti di Coin sono immutabili e hanno gli attributi `name` (nome della moneta) e `value` (valore della moneta);
- deve essere possibile recuperare l’informazione contenuta in ogni oggetto `Coin`;
- oltre ai metodi visti a lezione (`find`, `count`, `getMinimum`, `getMaximum`, `getTotal`), implementare anche:
    - `remove(Coin coin)`: rimuove una moneta di valore pari a `coin` se presente nella borsa;
    - `hasCoin(Coin coin)`: vale `true` se e solo se una moneta di valore pari a `coin` è presente nella borsa.

La borsa può contenere:

- `Dollar` dal valore di `1`;
- `Quarter` dal valore di `0.25`;
- `Dime` dal valore di `0.10`;
- `Nickel` dal valore di `0.05`;
- `Cent` dal valore di `0.01`;

Aggiungere alla classe `Purse`

- un metodo `toString` che restituisca una stringa:
    - `Purse[Dollar = $, Quarter = q, Dime = d, Nickel = n, Cent = c]`
    - dove `$`, `q`, `d`, `n`, `c` sono rispettivamente il numero di dollari, quarti, dime, nickel e cent contenuti
      nella borsa.
- un metodo `equals` che rispecchi la relazione di uguaglianza per la quale due borse sono uguali se e solo se
  contengono lo stesso assortimento di monete