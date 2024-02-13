package it.bd.sistema.noleggio.model;

public class Employee extends User {

    private final String cf;
    private final String name;
    private final long phone;

    public Employee(String username, RoleType role, String cf) {
        this(username, cf, null, 0, role);
    }
    public Employee(String cf, String name, long phone, RoleType role) {
        this(null, cf, name, phone, role);
    }
    public Employee(String username, String cf, String name, long phone, RoleType role) {
        super(username, role);
        this.cf = cf;
        this.name = name;
        this.phone = phone;
    }

    public Employee(String cf) {
        this(cf, null, 0, null);
    }

    public String getCf() {
        return cf;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }
}
