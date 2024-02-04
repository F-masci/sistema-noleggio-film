package it.bd.sistema.noleggio.model;

public class FilmCopy {

    private final int code;
    private final Film film;
    private final FilmCopyType type;
    private final int sector;
    private final String position;

    public FilmCopy(int code) {
        this(code, null, null, -1, null);
    }

    public FilmCopy(int code, Film film, FilmCopyType type) {
        this(code, film, type, -1, null);
    }

    public FilmCopy(int code, Film film, FilmCopyType type, int sector, String position) {
        this.code = code;
        this.film = film;
        this.type = type;
        this.sector = sector;
        this.position = position;
    }

    public int getCode() {
        return code;
    }

    public Film getFilm() {
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
