# Concessionaria Auto 2

Modificare il metodo `void readUserDataFromFile(File file)` della classe `CarSeller` per lanciare un’eccezione se il
file non ha il formato corretto.

Aggiungere il metodo `void writeUserDataToFile(File file, boolean overwrite)` alla
classe `CarSeller` per salvare i dati nello stesso formato di lettura.
Fare in modo che sia possibile sovrascrivere il file tramite il parametro `overwrite`.

Implementare `void writeSerializedDataToFile(File file)` e `void readSerializedDataToFile(File file)` per salvare e
leggere i dati come oggetti serializzati.