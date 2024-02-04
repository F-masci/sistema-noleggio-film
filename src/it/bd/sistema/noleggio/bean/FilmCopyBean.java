package it.bd.sistema.noleggio.bean;

import it.bd.sistema.noleggio.model.Film;
import it.bd.sistema.noleggio.model.FilmCopyType;

public class FilmCopyBean {

    private final int code;
    private final FilmBean film;
    private final FilmCopyType type;
    private final int sector;
    private final String position;

    public FilmCopyBean(int code) {
        this(code, null, null, -1, null);
    }

    public FilmCopyBean(int code, FilmBean film, FilmCopyType type) {
        this(code, film, type, -1, null);
    }

    public FilmCopyBean(int code, FilmBean film, FilmCopyType type, int sector, String position) {
        this.code = code;
        this.film = film;
        this.type = type;
        this.sector = sector;
        this.position = position;
    }

    public int getCode() {
        return code;
    }

    public FilmBean getFilm() {
        return film;
    }

    public FilmCopyType getType() {
        return type;
    }

    public int getSector() {
        return sector;
    }

    public String getPosition() {
        return position;
    }

}
