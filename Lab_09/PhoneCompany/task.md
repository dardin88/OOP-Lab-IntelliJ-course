# Compagnia telefonica

Una compagnia telefonica memorizza i consumi trimestrali dei propri utenti in un file organizzato come segue:

- Codice dell’utente;
- Nome dell’utente;
- Cognome dell’utente;
- Numero di minuti consumati;
- Numero di sms inviati;
- Numero di MB consumati.

Progettare e realizzare un programma per la fatturazione trimestrale, supponendo che i costi per minuti, sms e GB
siano stabiliti trimestre per trimestre.

Modificare il metodo `void readUserDataFromFile(File file)` della classe `PhoneCompany` per lanciare un’eccezione se il
file non ha il formato corretto.

Aggiungere il metodo `void writeUserDataToFile(File file, boolean overwrite)` alla
classe `PhoneCompany` per salvare i dati nello stesso formato di lettura.
Fare in modo che sia possibile sovrascrivere il file tramite il parametro `overwrite`.

Implementare `void writeSerializedDataToFile(File file)` e `void readSerializedDataToFile(File file)` per salvare e
leggere i dati come oggetti serializzati.