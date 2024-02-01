package it.bd.sistema.noleggio.model;

public class Employee extends User {

    private final String cf;
    private final String name;
    private final long phone;

    public Employee(String username, Role role, String cf) {
        this(cf, null, 0, role);
    }
    public Employee(String cf, String name, long phone, Role role) {
        super(null, role);
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
