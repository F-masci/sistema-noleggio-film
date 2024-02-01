package it.bd.sistema.noleggio.bean;

public class RegisterEmployeeBean {

    private final String username;
    private final String password;
    private final String role;
    private final String startDate;

    private final String cf;
    private final String name;
    private final long phone;

    public RegisterEmployeeBean(String cf) {
        this(null, null, null, null, cf, null, 0);
    }
    public RegisterEmployeeBean(String username, String password, String role, String startDate, String cf, String name, long phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.startDate = startDate;
        this.cf = cf;
        this.name = name;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getStartDate() {
        return startDate;
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
