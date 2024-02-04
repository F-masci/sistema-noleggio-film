package it.bd.sistema.noleggio.model;

public class User {

    private final String username;
    private final RoleType role;

    public User(String username, RoleType role) {
        this.username = username;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public RoleType getRole() {
        return role;
    }
}
