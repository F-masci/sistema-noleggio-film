package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmCopyBean;

import java.util.List;

public class FilmCopyListView extends GenericView {

    public static void printList(List<FilmCopyBean> list) {
        println("--- COPIE ---");
        for(FilmCopyBean l: list) {
            println(l.getFilm().getTitle() + " - " + l.getFilm().getDirector() + " -> " + l.getType().getType() + " #" + l.getCode() + ", settore #" + l.getSector() + " - " + l.getPosition());
        }
    }

}
