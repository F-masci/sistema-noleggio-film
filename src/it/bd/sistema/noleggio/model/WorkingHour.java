package it.bd.sistema.noleggio.model;

public class WorkingHour {

    private final int day;
    private final String hour;

    public WorkingHour(int day, String hour) {
        this.day = day;
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getFormattedHour() {
        return hour;
    }

}
