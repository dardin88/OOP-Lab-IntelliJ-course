# Scuola 2

Si completi la classe `Person`, aggiungendo `userId` e `password`.
`UserId` e `password` devono essere lunghi almeno 5 caratteri e non possono contenere spazi.

Modificare il costruttore in modo che includa questi due campi.
Se `userId` o `password` non hanno il formato specificato il costruttore deve lanciare l’eccezione
predefinita `IllegalArgumentException` contenente il messaggio `"Login dell’utente con formato errato"`
oppure `"Password dell’utente con formato errato"`.
La stessa tecnica si deve usare se nome e cognome sono `null` oppure se hanno lunghezza zero e se l’anno di nascita è
minore di 1900.

Si completi la classe `Student`, aggiungendo un hash table e una variabile per memorizzare la matricola dello studente.
Le chiavi dell’hash table contengono i nomi degli esami, mentre i valori i voti (memorizzati come interi dove 31
rappresenta il 30 e lode) che lo studente ha preso a quell’esame.
Se la matricola è vuota o `null` il costruttore deve lanciare l’eccezione predefinita `IllegalArgumentException`
contenente il messaggio `"Matricola dello studente con formato errato"`.

Per lo studente definire inoltre il metodo: `addExam(String examName, int grade)` che aggiungerà l’esame all’hash
table.
Se il voto non è compreso tra 18 e 31 lanciare l’eccezione `IllegalArgumentException` contenente il
messaggio `"Voto non valido (minore di 18 o maggiore di 30 e lode)"`.

Definire il metodo `getNumberOfPassedExams()` che restituisca il numero di esami passati.

Definire il metodo `getAverageGrade()` che restituisca il numero la media degli esami.
Se lo studente non ha sostenuto esami restituire zero.

Implementare i casi di test per collaudare il tutto.