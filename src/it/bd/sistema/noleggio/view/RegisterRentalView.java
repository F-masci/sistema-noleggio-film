package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.RentalBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RegisterRentalView extends GenericView {

    public static RentalBean registerRental() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new RentalBean(
                requestInt("Codice della copia da noleggiare: "),
                requestInt("Tessera cliente: "),
                requestDate("Data di scadenza (YYYY-MM-DD): ")
        );
    }

}
