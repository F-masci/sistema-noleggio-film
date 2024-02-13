package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class CashierView extends GenericView {

    public static int printCashierMenu() throws EscCliException {
        return  GenericView.printMenu("""
            
            --- CASSIERE ---
            
            Seleziona cosa vuoi fare
            [1] Timbra
            [2] Lista turni di lavoro
            [3] Registra cliente
            [4] Lista clienti
            [5] Rimuovi cliente
            [6] Inserisci recapito cliente
            [7] Rimuovi recapito cliente
            [8] Registra noleggio
            [9] Registra restituzione
            [10] Lista noleggi""", 10);
    }

}
