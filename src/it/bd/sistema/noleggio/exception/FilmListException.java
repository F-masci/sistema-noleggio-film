package it.bd.sistema.noleggio.exception;

public class FilmListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista dei film: ";

    public FilmListException(Throwable e) {
        this(e, e);
    }
    public FilmListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public FilmListException(String msg) {
        super(msg);
    }
    public FilmListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
