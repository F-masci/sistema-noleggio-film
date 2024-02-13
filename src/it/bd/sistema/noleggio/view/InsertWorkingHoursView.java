package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsertWorkingHoursView extends GenericView {

    public static WorkingHoursBean insertWorkingHoursView() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        String employee = requestFiscalCode( "Codice fiscale dell'impiegato: ");
        int month = requestInt("Mese: ");
        int year = requestInt("Anno: ");

        List<String> hours = new ArrayList<>();
        List<Integer> days = new ArrayList<>();

        println("""
                Per ogni giorno del mese inserire l'orario di ingresso e di uscita con il seguente formato: 00:00-00:00
                Il primo orario indica l'ingresso mentre il secondo indica l'uscita.
                Lasciare vuoto il giorno per indicare che il dipendente non deve recarsi a lavoro quel giorno.""");

        int numDays = LocalDate.of(year, month, 1).lengthOfMonth();
        for (int d = 1; d <= numDays; d++) {
            String h = requestWorkingHour(LocalDate.of(year, month, d) + ": ");
            if(!h.isBlank()) {
                hours.add(h);
                days.add(d);
            }
        }

        return new WorkingHoursBean(
                employee,
                year,
                month,
                days,
                hours
        );

    }

}
