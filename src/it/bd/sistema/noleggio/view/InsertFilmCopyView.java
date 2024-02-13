package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.bean.FilmCopyBean;
import it.bd.sistema.noleggio.exception.cli.EscCliException;
import it.bd.sistema.noleggio.model.FilmCopyType;
import it.bd.sistema.noleggio.utility.Validator;

public class InsertFilmCopyView extends GenericView {

    public static FilmCopyBean insertFilmCopy() throws EscCliException {
        println("Digitare esc durante l'inserimento per uscire");
        return new FilmCopyBean(
                requestInt("Codice: "),
                new FilmBean(
                        requestString("Titolo del film: "),
                        requestString("Regista del film: ")
                ),
                FilmCopyType.createFromString(requestTypeOfFilmCopy("Tipo di copia (DVD | Videocassetta): ")),
                requestInt("Codice del settore: "),
                requestString("Posizione all'interno del settore: ")
        );
    }

}
