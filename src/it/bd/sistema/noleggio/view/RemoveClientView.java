package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RemoveClientView extends GenericView {

    public static ClientBean removeClient() throws EscCliException {
        println("ATTENZIONE! Rimuovendo un cliente verranno rimosse anche i relativi noleggi");
        return new ClientBean(
                requestInt("Cliente (oppure esc per tornare indietro): ")
        );
    }

}
