package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.bean.RentalListBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

import java.util.List;

public class FilmRentalListView extends GenericRentalListView {

    public static FilmBean selectFilm() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new FilmBean(
                requestString("Titolo: "),
                requestString("Regista: ")
        );
    }

    public static void printList(List<RentalListBean> list) {
        GenericRentalListView.printList(list, "LISTA NOLEGGI DELL FILM");
    }

}
