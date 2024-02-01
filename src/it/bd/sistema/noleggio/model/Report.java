package it.bd.sistema.noleggio.model;

public class Report {

    private final String name;
    private final String time;
    private final String hours;

    public Report(String name, String time, String hours) {
        this.name = name;
        this.time = time;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getHours() {
        return hours;
    }


}
