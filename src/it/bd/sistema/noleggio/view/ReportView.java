package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ReportBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.List;

public class ReportView extends GenericView {

    public static int monthlyReport() throws EscCliException {
        return requestInt("Mese (oppure esc per tornare indietro): ");
    }

    public static int yearlyReport() throws EscCliException {
        return requestInt("Anno (oppure esc per tornare indietro): ");
    }

    public static void printReport(List<ReportBean> report) {
        println("--- REPORT ---");
        for(ReportBean r: report) {
            println(r.getName() + " - " + r.getTime() + ": " + r.getHours() + " ore lavorate");
        }
    }

}
