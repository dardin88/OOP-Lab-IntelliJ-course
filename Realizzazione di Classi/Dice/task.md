# Dado

Scrivere un programma che si comporti come segue:

1. Crea due conti correnti uno (conto giocatore) con importo iniziale pari a 1.000 euro e uno (conto casinò) con
   importo
   iniziale pari a 100.000 euro.
2. Prende in input da tastiera un intero `n` e un double `bet` e simula il lancio di un dado con sei facce. Se il
   risultato del lancio è `n` allora il programma trasferisce un importo pari a cinque volte il valore di `bet` dal
   conto del casinò al conto del giocatore; se il risultato è diverso da `n` il programma trasferisce un importo pari
   a `bet` dal conto del giocatore a quello del casinò. Il valore di `bet` deve essere inferiore al saldo del conto
   del giocatore e cinque volte più piccolo di quello del conto del casinò.
3. Se dopo la scommessa il giocatore dispone ancora di soldi sul conto, il programma chiede se si vuole continuare a
   scommettere. Se si digita 'si' il programma continua dal punto due. Se si digita qualcosa di diverso da 'si' oppure
   il saldo è zero il programma si interrompe stampando il saldo del conto del giocatore.