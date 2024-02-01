package it.bd.sistema.noleggio.bean;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class YearlyReportBean extends ReportBean {
    public YearlyReportBean(String name, String time, String hours) {
        super(name, time, hours);
    }

    @Override
    public String getTime() {
        return Month.of(Integer.parseInt(this.time)).getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
