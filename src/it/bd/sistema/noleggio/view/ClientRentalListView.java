package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.ClientBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.List;

public class ClientRentalListView extends GenericRentalListView {

    public static ClientBean selectClient() throws EscCliException {
        return new ClientBean(
                requestInt("Tessera cliente (oppure esc per tornare indietro): ")
        );
    }

    public static void printList(List<RentalListBean> list) {
        GenericRentalListView.printList(list, "LISTA NOLEGGI DEL CLIENTE");
    }

}
