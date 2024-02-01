package it.bd.sistema.noleggio.bean;

public class MonthlyReportBean extends ReportBean {
    public MonthlyReportBean(String name, String time, String hours) {
        super(name, time, hours);
    }

    @Override
    public String getTime() {
        return super.time;
    }
}
