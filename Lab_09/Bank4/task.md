# Banca 3

Aggiungere alla classe `Bank` un metodo `void readFile(File file)` che legga un file scritto con il seguente formato:

```
accountNumber1, customerName1, balance1
accountNumber2, customerName2, balance2, interestRate
accountNumber3, customerName3, balance3,
```

Aggiungere il metodo `void writeUserDataToFile(File file, boolean overwrite)` alla classe `Bank` per salvare i dati
nello stesso formato di lettura. Fare in modo che sia possibile sovrascrivere il file tramite il parametro `overwrite`.

Implementare `void writeSerializedDataToFile()` e `void readSerializedDataToFile()` per salvare e leggere i dati come
oggetti serializzati.

Testare le funzionalità implementate.