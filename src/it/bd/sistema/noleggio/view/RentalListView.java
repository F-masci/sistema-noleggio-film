package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RentalListView extends GenericView {

    public static int printRentalListMenu() throws EscCliException {
        return  GenericView.printMenu("""
            
            --- NOLEGGI ---
            
            Seleziona quali noleggi
            [1] Noleggi correnti
            [2] Noleggi scaduti
            [3] Noleggi di una copia
            [4] Noleggi di un cliente
            [5] Noleggi di un film""", 5);
    }

}
