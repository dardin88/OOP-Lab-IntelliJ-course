# Archivio Automezzi

Implementare:

- la classe `Vehicle` caratterizzata da modello, marca, targa, anno;
- la sottoclasse `MotorVehicle` caratterizzata da alimentazione, numero di porte e numero di posti.
  La targa di un autoveicolo ha il formato `LLNNNLL`, dove `L` è una lettera mentre `N` è un numero.
- la sottoclasse `MotorCycle` caratterizzata da numero di ruote e numero di passeggeri.
  La targa di un motociclo ha il formato `LLNNNNN`, dove `L` è una lettera mentre `N` è un numero.

Definire un’eccezione controllata `WrongLicensePlateException e` un’eccezione non controllata `BadDataFormatException`.

Scrivere una classe `VehicleManager` che modelli un insieme di automezzi e una classe `VehicleGUI` che includa tutti i
metodi necessari all’implementazione dell’interfaccia grafica per:

- caricare da un file e salvare in un file una lista di automezzi, lanciare l’eccezione `BadDataFormatException`
  nel caso in cui il file non sia nel formato richiesto.
- ricercare automezzi (consentire di filtrare gli autoveicoli per targa, alimentazione e numero di posti e di filtrare i
  motocicli per targa, anno e numero di ruote). Le caselle combinate devono essere popolate con i corrispondenti valori
  presenti nell’archivio, ad esempio se le autovetture dell’archivio hanno numeri di posti pari a 2, 4 e 5 allora solo
  questi valori saranno presenti nella lista. Se nessuna casella del form di ricerca viene impostata allora il bottone
  cerca consente di visualizzare tutte gli autoveicoli o tutti i motocicli (in base a quale radio button è attivo). Se
  viene effettuata una ricerca per targa ma il formato dell’input non è conforme allo standard occorre lanciare
  l’eccezione `WrongLicensePlateException` e gestirla visualizzando il messaggio ottenuto tramite
  `JOptionPane.showMessageDialog(null, “Messaggio”, “Titolo”, JOptionPane.ERROR_MESSAGE)`.
- se la ricerca per targa non produce risultati viene mostrato il seguente messaggio ottenuto tramite
  `JOptionPane.showConfirmDialog(null, “Messaggio")`. In caso di risposta affermata viene mostrato un form per
  l’inserimento di un autoveicolo o motociclo a seconda del valore selezionato nel radio button.