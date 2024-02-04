package it.bd.sistema.noleggio.exception;

public class FilmCopyListException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la generazione della lista delle copie del film: ";

    public FilmCopyListException(Throwable e) {
        this(e, e);
    }
    public FilmCopyListException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public FilmCopyListException(String msg) {
        super(msg);
    }
    public FilmCopyListException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
