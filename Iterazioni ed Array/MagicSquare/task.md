# Quadrato magico

Una matrice `n×n` riempita con i numeri `1, 2, 3, ..., n^2` è un quadrato magico se la somma degli elementi di ogni
riga, di
ogni colonna e delle due diagonali ha lo stesso valore.

Scrivere un programma che legga `n^2` valori dalla tastiera e verifichi se, disposti in una matrice, formino un quadrato
magico.

Quando viene inserito un valore nel quadrato verificare se questo non sia già stato inserito in precedenza. Nel caso
questo sia avvenuto si deve far inserire un nuovo valore.
Realizzare una classe Square con i metodi seguenti:

- `public void add(int x)`
- `public boolean isMagic()`