# Paghe orarie

Implementare le classi:

- `Staff` ha un nome, un cognome e una retribuzione
- `Employee` ha un nome, un cognome, una retribuzione, un incarico
- `Manager` ha un nome, un cognome, una retribuzione, un incarico, un’area di competenza

Per ogni classe implementare il metodo `toString`.

I direttori (i.e., `Manager`) sono retribuiti a ore, mentre gli impiegati (i.e., `Employee`) con un fisso settimanale.

Per i lavoratori a ore, la paga settimanale è calcolata moltiplicando la paga oraria per il numero di ore effettivamente
lavorate fino a un massimo di 40 ore, se le ore lavorate eccedono le 40 ore, allora la parte di ore eccedente 40 viene
retribuita una volta e mezzo la paga oraria ordinaria.

I lavoratori retribuiti con un fisso ricevono la paga di 40 ore indipendentemente dalle ore effettivamente lavorate.

Progettare e testare le classi necessarie per il calcolo delle paghe settimanali tenendo conto che le paghe vengono
aggiornate nel costruttore, al cambio di ore lavorate e in quello di paga oraria.