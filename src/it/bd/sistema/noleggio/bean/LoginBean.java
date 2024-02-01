package it.bd.sistema.noleggio.bean;

public class LoginBean {

    private final String username;
    private final String password;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
