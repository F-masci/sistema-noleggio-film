package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.EmployeeBean;
import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.List;

public class EmployeeListView extends GenericView {

    public static void printList(List<EmployeeBean> list) {
        println("--- IMPIEGATI ---");
        for(EmployeeBean l: list) {
            println(l.getCf() + " -> " + l.getName() + " (" + l.getUsername() + "): " + l.getRole());
        }
    }

}
