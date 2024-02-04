package it.bd.sistema.noleggio.bean;

import it.bd.sistema.noleggio.model.FilmCopyType;

public class ExpiredRentalBean extends RentalBean {

    private final String title;
    private final String director;
    private final FilmCopyType type;
    private final String cf;
    private final String name;
    private final String surname;

    public ExpiredRentalBean(int copy, String title, String director, FilmCopyType type, int client, String cf, String name, String surname, String expiration) {
        super(copy, client, expiration);
        this.title = title;
        this.director = director;
        this.type = type;
        this.cf = cf;
        this.name = name;
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public FilmCopyType getType() {
        return type;
    }

    public String getCf() {
        return cf;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
