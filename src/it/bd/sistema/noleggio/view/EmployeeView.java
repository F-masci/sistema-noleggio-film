package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class EmployeeView extends GenericView {

    public static int printOwnerMenu() throws EscCliException {
        return  EmployeeView.printMenu("""
                    
                    --- IMPIEGATO ---
                    
                    Seleziona cosa vuoi fare
                    [1] Timbra""", 1);
    }

}
