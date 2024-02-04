package it.bd.sistema.noleggio.exception;

public class RemoveFilmException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante la rimozione del film: ";

    public RemoveFilmException(Throwable e) {
        this(e, e);
    }
    public RemoveFilmException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public RemoveFilmException(String msg) {
        super(msg);
    }
    public RemoveFilmException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
