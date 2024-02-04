package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.List;

public class WorkingHoursListView extends GenericView {

    public static WorkingHoursBean workingHoursList() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new WorkingHoursBean(
                requestString("Codice fiscale dell'impiegato: "),
                requestInt("Anno: "),
                requestInt("Mese: ")
        );
    }

    public static void printList(WorkingHoursBean bean) {
        println("--- TURNI DI LAVORO ---");
        List<Integer> days = bean.getDays();
        List<String> hours = bean.getHours();
        for(int i=0; i<days.size() && i<hours.size(); i++) {
            Integer day = days.get(i);
            String hour = hours.get(i);
            println(bean.getYear() + "-" + bean.getMonth() + "-" + day + ": " + hour);
        }
    }

}
