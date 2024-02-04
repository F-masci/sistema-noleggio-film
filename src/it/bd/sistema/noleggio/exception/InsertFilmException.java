package it.bd.sistema.noleggio.exception;

public class InsertFilmException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento del film: ";

    public InsertFilmException(Throwable e) {
        this(e, e);
    }
    public InsertFilmException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public InsertFilmException(String msg) {
        super(msg);
    }
    public InsertFilmException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
