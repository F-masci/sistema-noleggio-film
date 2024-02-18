package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class OwnerView extends GenericView {

    public static int printOwnerMenu() throws EscCliException {
        return  GenericView.printMenu("""
            
            --- PROPRIETARIO ---
            
            Seleziona cosa vuoi fare (oppure esc per uscire dal sistema)
            [1] Registra impiegato
            [2] Lista impiegati
            [3] Rimuovi impiegato
            [4] Modifica carica di un impiegato
            [5] Storico cariche di un impiegato
            [6] Inserisci turno di lavoro
            [7] Lista turni di lavoro
            [8] Rimuovi turno di lavoro
            [9] Report mensile
            [10] Report annuale
            [11] Inserisci film nel catalogo
            [12] Lista film nel catalogo
            [13] Rimuovi film dal catalogo
            [14] Inserisci settore
            [15] Lista settori
            [16] Rimuovi settore
            [17] Inserisci copia di film
            [18] Lista delle copie di film
            [19] Rimuovi copia di film""", 19);
    }

}
