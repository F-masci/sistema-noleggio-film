package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RegisterEmployeeView extends GenericView {

    public static EmployeeBean registerEmployee() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new EmployeeBean(
                requestString( "Username: "),
                requestString("Password: "),
                requestString("Ruolo (Cassiere | Commesso): "),
                requestString("Data di inizio carica (YYYY-MM-DD): "),
                requestString( "Codice fiscale: "),
                requestString("Nome: "),
                requestLong("Recapito: ")
        );
    }

}
