package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.bean.WorkingHoursBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.Employee;
import it.bd.sistema.noleggio.model.RoleType;
import it.bd.sistema.noleggio.utility.LoggedUser;

import java.util.List;

public class WorkingHoursListView extends GenericView {

    public static WorkingHoursBean workingHoursList() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        String cf;
        if(LoggedUser.getLoggedUser().getRole() == RoleType.OWNER) {
            cf = requestFiscalCode("Codice fiscale dell'impiegato: ");
        } else {
            cf = ((Employee) LoggedUser.getLoggedUser()).getCf();
        }
        return new WorkingHoursBean(
                cf,
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
