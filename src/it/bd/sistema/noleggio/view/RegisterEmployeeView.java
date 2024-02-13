package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RegisterEmployeeView extends GenericView {

    public static EmployeeBean registerEmployee() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new EmployeeBean(
                requestString( "Username: "),
                requestString("Password: "),
                requestRole("Ruolo (Cassiere | Commesso): "),
                requestDate("Data di inizio carica (YYYY-MM-DD): "),
                requestFiscalCode( "Codice fiscale: "),
                requestString("Nome: "),
                requestPhoneNumber("Recapito: ")
        );
    }

}
