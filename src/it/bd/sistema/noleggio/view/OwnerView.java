package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class OwnerView extends GenericView {

    public static int printOwnerMenu() throws EscCliException {
        return  OwnerView.printMenu("""
                    
                    --- PROPRIETARIO ---
                    
                    Seleziona cosa vuoi fare
                    [1] Registra impiegato
                    [2] Modifica carica di un impiegato
                    [3] Inserisci turno di lavoro
                    [4] Report mensile
                    [5] Report annuale""", 5);
    }

}
