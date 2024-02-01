package it.bd.sistema.noleggio.bean;

public abstract class ReportBean {

    private final String name;
    protected final String time;
    private final String hours;

    public ReportBean(String name, String time, String hours) {
        this.name = name;
        this.time = time;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public abstract String getTime();

    public String getHours() {
        return hours;
    }

}
