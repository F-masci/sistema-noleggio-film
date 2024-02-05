package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class CashierView extends GenericView {

    public static int printCashierMenu() throws EscCliException {
        return  GenericView.printMenu("""
            
            --- CASSIERE ---
            
            Seleziona cosa vuoi fare
            [1] Timbra
            [2] Registra cliente
            [3] Lista clienti
            [4] Rimuovi cliente
            [5] Inserisci recapito cliente
            [6] Rimuovi recapito cliente
            [7] Registra noleggio
            [8] Registra restituzione
            [9] Lista noleggi""", 9);
    }

}
