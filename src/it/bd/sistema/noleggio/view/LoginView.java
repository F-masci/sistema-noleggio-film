package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.LoginBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class LoginView extends GenericView {

    public static LoginBean login() {
        println("""
                |*****************************************|
                | SISTEMA DI NOLEGGIO DVD E VIDEOCASSETTE |
                |*****************************************|
                                    
                Esegui il login per accedere al sistema""");
        String username = requestString("Username: ");
        String password = requestString("Password: ");
        return new LoginBean(username, password);
    }

}
