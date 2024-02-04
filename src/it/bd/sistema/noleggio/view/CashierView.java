package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class CashierView extends GenericView {

    public static int printCashierMenu() throws EscCliException {
        return  GenericView.printMenu("""
            
            --- CASSIERE ---
            
            Seleziona cosa vuoi fare
            [1] Timbra
            [2] Registra cliente
            [3] Inserisci recapito cliente
            [4] Registra noleggio
            [5] Registra restituzione
            [6] Lista noleggi scaduti""", 6);
    }

}
