# Supermercato

Implementare in Java la classe `Product` che modelli i prodotti venduti da un supermercato.
Ogni prodotto è caratterizzato da codice, descrizione, marca, prezzo, quantità e `onSale` (una variabile booleana
indicante se il prodotto è in offerta).

Corredare la classe con i metodi

- `void putOnSale(double p, GregorianCalendar g)` che definisca un’offerta di percentuale `p` con data di scadenza
  dell’offerta `g`. Tale metodo setta a `true` lo stato della variabile `onSale` e applica la percentuale di sconto `p`
  sul prodotto.
- `void checkOnSale()` che setti a `false` lo stato della variabile `onSale` e ristabilisca il prezzo del prodotto se la
  data di scadenza dell’offerta è successiva alla data corrente.

Nota: per ottenere l’ora corrente utilizzate la classe `GregorianCalendar`.

Definire inoltre due sottoclassi:

- `Grocery` caratterizzata da una data di scadenza, un peso e i seguenti metodi
    - `boolean isExpired()` che verifica se il prodotto sia scaduto.
    - `boolean buy(int p)` che simuli l’acquisto di `p` grammi di prodotto. Se la variabile `p` non eccede la quantità
      disponibile del prodotto allora il prodotto può essere acquistato. Restituisce `true` in caso di acquisto.
- `Electronic` caratterizzata da una quantità e le variabili `basicWarranty` (numero di anni per cui il prodotto è
  garantito) e `annualWarrantyPrice` (costo annuale per estendere la garanzia) e abbia i seguenti metodi:
    - `double computeWarrantyPrice(int a)` che calcoli il costo della garanzia per `a` anni.
    - `boolean buy(int q)` che simuli l’acquisto di `q` prodotti. Se la variabile `q` non eccede la quantità presente
      nel magazzino allora il prodotto può essere acquistato. Restituisce `true` in caso di acquisto.

Scrivere la classe `Supermarket` che modelli una collezione di prodotti e fornisca i seguenti metodi:

- `void addProduct(Product p)` che inserisca un prodotto in modo ordinato rispetto al codice. L’implementazione scelta
  deve favorire il riutilizzo del codice e la versatilità rispetto ad altri criteri di ordinamento. Ad esempio, se in
  futuro si vuole ordinare rispetto al prezzo, vogliamo poter aggiungere soltanto una nuova classe che implementi la
  relazione d’ordine per il prezzo senza modificare il resto del codice.
- `String getProductType(int i)` che restituisca il tipo dell’i-esimo prodotto (alimentare o elettronico).
- `Product getMinPrice()` che restituisca il prodotto che ha il costo minimo.
- `Product getMaxPrice()` che restituisca il prodotto che ha il costo massimo.
- `List< Product> find(String brand)` che restituisca tutti i prodotti di una certa marca.