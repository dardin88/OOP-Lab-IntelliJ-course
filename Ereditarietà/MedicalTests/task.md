# Esami Medici

Definire la classe `MedicalTest` che modelli un esame medico effettuato in una clinica.

Ogni `MedicalTest` è caratterizzato dal nome del medico, il costo, il referto e la data di effettuazione, e fornisce
tra gli altri i seguenti metodi:

- un costruttore `MedicalTest(String doctorName, float cost)`;
- `conductTest(String report, GregorianCalendar date)` che imposti il referto dell’esame;
- `toString()` che restituisca i dati dell’esame.

Definire due sottoclassi `Radiography` ed `Echocardiogram`.

`Radiography` è caratterizzata dal nome del file contenente l’immagine, dal nome dell’organo radiografato (e.g., torace,
polmone, braccio) e da un’impegnativa che indichi se la radiografia è stata richiesta da un medico. Il costo di una
radiografia è 20€ senza impegnativa e 13€ con l’impegnativa.

`Echocardiogram` è caratterizzato da una tipologia (“semplice”, “con contrasto” e “da sforzo”) e dall’età del paziente.
Il costo di un ecocardiogramma dipende da entrambi gli attributi. In particolare l’ecocardiogramma con contrasto costa
45€ mentre gli altri costano 30€. A tale costo viene applicato uno sconto del 20% nel caso in cui l’età del paziente è
almeno 65 anni.

Definire la classe `MedicalTestList` che rappresenti l’elenco degli esami effettuati e fornisca i seguenti metodi:
- un costruttore `MedicalTestList()`;
- `addMedicalTest(MedicalTest mt)` che inserisca un esame nell’elenco in modo ordinato rispetto alla data del referto;
- `getMedicalTestByDate(GregorianCalendar date)` che restituisca la lista degli esami effettuati nel dato giorno;
- `getMedicalTestByDoctor(String doctorName)` che restituisca la lista degli esami effettuati da un medico;
- `getAverageCost()` che restituisca il costo medio degli esami effettuati.

Implementare e testare le classi.