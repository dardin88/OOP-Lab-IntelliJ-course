# Concessionaria Auto

Una concessionaria di auto usate ha deciso di organizzare le proprie giacenze in un archivio elettronico. L’archivio è
realizzato mediante un file che associa a ogni auto disponibile quattro righe successive con le seguenti informazioni:

- la prima riga contiene la marca dell’auto (es. Tesla)
- la seconda il modello di auto (es. Model Y)
- la terza l’anno di immatricolazione (es. 2020)
- la quarta il costo (es. 35.000)

La concessionaria vuole realizzare un sistema in grado di fornire risposte alle seguenti interrogazioni:

- conoscere se è disponibile un’auto di una certa marca e modello;
- conoscere se è disponibile un’auto di una certa marca e modello immatricolata non prima di un certo anno;
- conoscere se è disponibile un’auto di una certa marca e modello in una determinata fascia di prezzo.

Modificare il metodo `void readUserDataFromFile(File file)` della classe `CarSeller` per lanciare un’eccezione se il
file non ha il formato corretto.

Aggiungere il metodo `void writeUserDataToFile(File file, boolean overwrite)` alla
classe `CarSeller` per salvare i dati nello stesso formato di lettura.
Fare in modo che sia possibile sovrascrivere il file tramite il parametro `overwrite`.

Implementare `void writeSerializedDataToFile(File file)` e `void readSerializedDataToFile(File file)` per salvare e
leggere i dati come oggetti serializzati.