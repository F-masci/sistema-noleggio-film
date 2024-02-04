package it.bd.sistema.noleggio.model;

public class Role {

    private final Employee employee;
    private final String start;
    private final String end;
    private final RoleType role;

    public Role(String start, String end, RoleType role) {
        this(null, start, end, role);
    }
    public Role(Employee employee) {
        this(employee, null, null, null);
    }
    public Role(Employee employee, String start, String end, RoleType role) {
        this.employee = employee;
        this.start = start;
        this.end = end;
        this.role = role;
    }

    public Employee getEmployee() {
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
