package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmBean;

public class RemoveFilmView extends GenericView {

    public static FilmBean removeFilm() {
        println("ATTENZIONE! Rimuovendo un film verranno rimosse anche le relative copie di quel film e i noleggi collegati a tali copie");
        println("Digitare esc durante l'inserimento per uscire");
        return new FilmBean(
                requestString("Titolo: "),
                requestString("Regista: ")
        );
    }

}
