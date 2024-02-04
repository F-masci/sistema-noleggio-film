package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.RentalBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RegisterReturnView extends GenericView {

    public static RentalBean registerReturn() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new RentalBean(
                requestInt("Codice della copia da restituire: "),
                requestInt("Tessera cliente: ")
        );
    }

}
