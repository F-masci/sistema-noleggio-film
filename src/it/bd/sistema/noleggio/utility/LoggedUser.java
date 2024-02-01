package it.bd.sistema.noleggio.utility;

import it.bd.sistema.noleggio.model.User;

public class LoggedUser {

    private static User user;

    public static void setLoggedUser(User user) {
        LoggedUser.user = user;
    }

    public static User getLoggedUser() {
        return user;
    }

}
