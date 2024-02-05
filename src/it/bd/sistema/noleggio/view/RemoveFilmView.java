package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;

public class RemoveFilmView extends GenericView {

    public static FilmBean removeFilm() throws EscCliException {
        println("ATTENZIONE! Rimuovendo un film verranno rimosse anche le relative copie di quel film e i noleggi collegati a tali copie");
        println("Digitare esc durante l'inserimento per uscire");
        return new FilmBean(
                requestString("Titolo: "),
                requestString("Regista: ")
        );
    }

}
