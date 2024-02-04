package it.bd.sistema.noleggio.exception;

public class InsertFilmCopyException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento della copia del film: ";

    public InsertFilmCopyException(Throwable e) {
        this(e, e);
    }
    public InsertFilmCopyException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public InsertFilmCopyException(String msg) {
        super(msg);
    }
    public InsertFilmCopyException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
