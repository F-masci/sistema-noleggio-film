package it.bd.sistema.noleggio.bean;

import java.util.List;

public class WorkingHoursBean {

    private final String employee;
    private final int year;
    private final int month;
    private final List<Integer> days;
    private final List<String> hours;

    public WorkingHoursBean(String employee, int year, int month) {
        this(employee, year, month, null, null);
    }
    public WorkingHoursBean(String employee, int year, int month, List<Integer> days, List<String> hours) {
        this.employee = employee;
        this.year = year;
        this.month = month;
        this.days = days;
        this.hours = hours;
    }

    public String getEmployee() {
        return employee;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public List<Integer> getDays() {
        return days;
    }

    public List<String> getHours() {
        return hours;
    }

}
