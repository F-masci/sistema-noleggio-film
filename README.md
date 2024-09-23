# sistema-noleggio-film
Repository per lo sviluppo del progetto di Basi di Dati (a.a. 2023/2024) presso l'università di Tor Vergata - autor3: Francesco Masci

## Specifiche di progetto
Questo repository contiene gli artefatti di un progetto per l'implementazione di un database. Partendo da un insieme iniziale di requisiti vaghi, il progetto ha coinvolto un continuo raffinamento delle specifiche, la creazione di modelli concettuali e logici dei dati e lo sviluppo di un'interfaccia thin client basata su Java.

_Si vuole realizzare un sistema informativo per la gestione di un negozio per il noleggio di videocassette e DVD, tenendo conto delle seguenti informazioni.
Il sistema mantiene le informazioni relative a tutte le persone impiegate presso il negozio. Per ciascun impiegato sono noti il codice fiscale, il nome, ed un recapito. Inoltre si vuole tenere traccia della carica che ha rivestito in un determinato periodo (per esempio, cassiere o commesso) considerando che tale qualifica può cambiare nel tempo. Le informazioni sul personale sono gestite dal proprietario del negozio, che è in grado di inserire nuovo personale nel sistema e di visualizzare report mensili ed annuali sulle ore lavorate dai dipendenti. I turni di lavoro sono inseriti, su base mensile, sempre dal proprietario.
I film disponibili presso il negozio sono identificati dal titolo e dal nome del regista; inoltre sono noti l’anno in cui il film è stato girato, l’elenco degli attori principali del film, il costo corrente di noleggio della videocassetta ed eventualmente i film disponibili presso la catena di cui il film in questione rappresenta la versione “remake”.
Per ogni film è nota la collocazione all’interno del negozio. In particolare, sono noti il settore, la posizione all’interno del settore ed il numero di copie in cui il film è disponibile. Ciascun settore è identificato attraverso un codice numerico univoco all’interno del negozio.
I clienti, al momento della registrazione al negozio, ricevono una tessera cliente. Per ciascun cliente devono essere mantenute tutte le informazioni anagrafiche e viene associato anche un numero arbitrario di recapiti (telefono, email, cellulare) a cui possono essere contattati. Quando un cliente effettua un noleggio, viene registrata la data entro cui il film dovrà essere restituito. Il personale di cassa può gestire l’anagrafica dei clienti e gestire i noleggi. Inoltre, può visualizzare in ogni momento quali titoli sono associati ad un noleggio scaduto e quali sono i clienti che hanno effettuato tali noleggi._

## Schemi del Database

### Schema Concettuale

![Schema Concettuale](relazione/diagramma_ER_concettuale.jpg)

Lo schema concettuale mostra le entità principali del database e le loro relazioni.

### Schema Logico

![Schema Logico](relazione/schema_logico.png)

Lo schema logico rappresenta la traduzione dello schema concettuale in una struttura relazionale.
