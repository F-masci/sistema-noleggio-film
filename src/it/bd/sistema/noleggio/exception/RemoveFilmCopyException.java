package it.bd.sistema.noleggio.exception;

public class RemoveFilmCopyException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la rimozione della copia del film: ";

    public RemoveFilmCopyException(Throwable e) {
        this(e, e);
    }
    public RemoveFilmCopyException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveFilmCopyException(String msg) {
        super(msg);
    }
    public RemoveFilmCopyException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
