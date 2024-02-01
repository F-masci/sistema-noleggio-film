package it.bd.sistema.noleggio;

import it.bd.sistema.noleggio.controller.LoginController;

public class SistemaNoleggio {

    public static void main(String[] args) {
        LoginController controller = new LoginController();
        controller.start();
    }

}
