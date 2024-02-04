package it.bd.sistema.noleggio.exception;

public class InsertSectorException extends DaoException {

    private static final String DEFAULT_MSG = "Errore durante l'inserimento del settore: ";

    public InsertSectorException(Throwable e) {
        this(e, e);
    }
    public InsertSectorException(Throwable e, Throwable cause) {
        this(DEFAULT_MSG + e.getMessage(), cause);
    }

    public InsertSectorException(String msg) {
        super(msg);
    }
    public InsertSectorException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
