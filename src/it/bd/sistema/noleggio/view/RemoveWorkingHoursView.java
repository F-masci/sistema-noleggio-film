package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RemoveWorkingHoursView extends GenericView {

    public static WorkingHoursBean removeWorkingHoursView() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        String employee = requestString( "Codice fiscale dell'impiegato: ");
        int month = requestInt("Mese: ");
        int year = requestInt("Anno: ");
        return new WorkingHoursBean(
                employee,
                year,
                month
        );

    }

}
