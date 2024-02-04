package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmCopyBean;

public class RemoveFilmCopyView extends GenericView {

    public static FilmCopyBean removeFilmCopy() {
        println("ATTENZIONE! Rimuovendo una copia verranno rimossi anche i noleggi relativi a tale copia");
        return new FilmCopyBean(
                requestInt("Codice della copia (oppure esc per tornare indietro): ")
        );
    }

}
