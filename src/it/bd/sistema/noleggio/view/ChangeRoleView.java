package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ChangeRoleBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class ChangeRoleView extends GenericView {

    public static ChangeRoleBean changeRole() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new ChangeRoleBean(
                requestString( "Codice fiscale dell'impiegato: "),
                requestString("Data di fine della carica precedente (YYYY-MM-DD): "),
                requestString("Ruolo (Cassiere | Commesso): ")
        );
    }

}
