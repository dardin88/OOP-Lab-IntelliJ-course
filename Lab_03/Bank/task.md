# Banca

Implementare e testare la classe `Bank` che contenga un vettore di oggetti di tipo `BankAccount` e abbia i metodi:

- `addAccount(initialBalance, customerName)`
- `deposit(accountNumber, amount)`
- `withdraw(accountNumber, amount)`
- `getBalance(accountNumber)`
- `transfer(fromAccountNumber, toAccountNumber, amount)`

Si ricordi che in `withdaw` è permesso prelevare in negativo.
L’alternativa consiste nel lanciare un’eccezione (vedere le prossime lezioni).