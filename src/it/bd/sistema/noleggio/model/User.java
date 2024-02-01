package it.bd.sistema.noleggio.model;

public class User {

    private final String username;
    private final Role role;

    public User(String username, Role role) {
        this.username = username;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
}
