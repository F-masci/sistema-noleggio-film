package it.bd.sistema.noleggio.bean;

public class ChangeRoleBean {

    private final String cf;
    private final String date;
    private final String role;

    public ChangeRoleBean(String cf, String date, String role) {
        this.cf = cf;
        this.date = date;
        this.role = role;
    }

    public String getCf() {
        return cf;
    }

    public String getDate() {
        return date;
    }

    public String getRole() {
        return role;
    }


}
