package it.bd.sistema.noleggio.bean;

import it.bd.sistema.noleggio.model.RoleType;

public class RoleBean {

    private final String employee;
    private final String start;
    private final String end;
    private final RoleType role;

    public RoleBean(String start, String end, RoleType role) {
        this(null, start, end, role);
    }
    public RoleBean(String employee) {
        this(employee, null, null, null);
    }
    public RoleBean(String employee, String start, String end, RoleType role) {
        this.employee = employee;
        this.start = start;
        this.end = end;
        this.role = role;
    }

    public String getEmployee() {
        return employee;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public RoleType getRole() {
        return role;
    }

}
