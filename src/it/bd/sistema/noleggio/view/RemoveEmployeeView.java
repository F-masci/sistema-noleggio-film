package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RemoveEmployeeView extends GenericView {

    public static EmployeeBean removeEmployee() throws EscCliException {
        println("ATTENZIONE! Rimuovendo un impiegato verranno rimossi anche i dati relativi dei turni di lavoro dell'impiegato e le cariche rivestite dall'impiegato nel negozio");
        return new EmployeeBean(requestString("Codice fiscale impiegato (oppure esc per tornare indietro): "));
    }

}
