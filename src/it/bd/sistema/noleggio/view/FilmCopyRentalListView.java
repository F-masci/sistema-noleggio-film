package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.List;

public class FilmCopyRentalListView extends GenericRentalListView {

    public static FilmCopyBean selectCopy() throws EscCliException {
        return new FilmCopyBean(
                requestInt("Codice della copia (oppure esc per tornare indietro): ")
        );
    }

    public static void printList(List<RentalListBean> list) {
        GenericRentalListView.printList(list, "LISTA NOLEGGI DELLA COPIA");
    }

}
