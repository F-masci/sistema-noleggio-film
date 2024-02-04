package it.bd.sistema.noleggio.view;

import it.bd.sistema.noleggio.bean.FilmBean;
import it.bd.sistema.noleggio.exception.cli.ContinueCliException;
import it.bd.sistema.noleggio.utility.Price;

import java.util.ArrayList;
import java.util.List;

public class InsertFilmView extends GenericView {

    public static FilmBean insertFilm() {
        println("Digitare esc durante l'inserimento per uscire");
        FilmBean bean = new FilmBean(
                requestString("Titolo: "),
                requestString("Regista: "),
                requestInt("Anno: "),
                new Price(
                        requestFloat("Costo DVD: "),
                        requestFloat("Costo videocassetta: ")
                ),
                new FilmBean(
                        requestString("Titolo del film di cui è il remake (lasciare vuoto se il film è originale): "),
                        requestString("Regista del film di cui è il remake (lasciare vuoto se il film è originale): ")
                )
        );

        println("""
                Attori principali del film.
                Durante l'inserimento dei recapiti digitare la parola 'fine' per terminare l'inserimento
                """);

        List<String> actorNames = new ArrayList<>();
        List<String> actorSurnames = new ArrayList<>();

        try {

            String name;
            String surname;

            while (true) {
                name = requestString("Nome attore: ");
                surname = requestString("Cognome attore: ");
                actorNames.add(name);
                actorSurnames.add(surname);
            }
        } catch(ContinueCliException ignored) {}

        bean.setActorNames(actorNames);
        bean.setActorSurnames(actorSurnames);

        return bean;

    }

}
